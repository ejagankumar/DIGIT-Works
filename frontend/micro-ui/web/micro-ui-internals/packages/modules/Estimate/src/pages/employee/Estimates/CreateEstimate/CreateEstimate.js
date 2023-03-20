import { Card, StatusTable, Row, Header, HorizontalNav, ActionBar, SubmitBar, WorkflowModal, FormComposer, Loader, Toast, ViewDetailsCard } from '@egovernments/digit-ui-react-components'
import React,{Fragment,useEffect,useState} from 'react'
import { useTranslation } from 'react-i18next'
import getModalConfig from './config'
import { createEstimateConfig } from './createEstimateConfig'
import { createEstimatePayload } from './createEstimatePayload'
import { useHistory } from "react-router-dom";



const configNavItems = [
    {
        name: "Project Details",
        code: "WORKS_PROJECT_DETAILS"
    },
    {
        name: "Work Details",
        code: "WORKS_WORK_DETAILS"
    },
]
const CreateEstimate = ({ EstimateSession }) => {
    const { t } = useTranslation()

    const [showToast, setShowToast] = useState(null)
    const { tenantId, projectNumber } = Digit.Hooks.useQueryParams();
    const searchParams = {
        Projects: [
            {
                tenantId,
                projectNumber: projectNumber
            }
        ]
    }
    const filters = {
        limit: 11,
        offset: 0,
        includeAncestors: true,
        includeDescendants: true
    }

    const headerLocale = Digit.Utils.locale.getTransformedLocale(tenantId);
    const { data:projectData, isLoading } = Digit.Hooks.works.useViewProjectDetails(t, tenantId, searchParams, filters, headerLocale);

    const cardState = {

        "title": " ",
        "asSectionHeader": true,
        values: [
            {
                "title": "WORKS_ESTIMATE_TYPE",
                "value": "Original Estimate"
            },
            {
                "title": "WORKS_PROJECT_ID",
                "value": projectData?.projectDetails?.searchedProject?.basicDetails?.projectID
            },
            {
                "title": "WORKS_DATE_PROPOSAL",
                "value": projectData?.projectDetails?.searchedProject?.basicDetails?.projectProposalDate
            },
            {
                "title": "WORKS_PROJECT_NAME",
                "value": projectData?.projectDetails?.searchedProject?.basicDetails?.projectName
            },
            {
                "title": "PROJECTS_DESCRIPTION",
                "value": projectData?.projectDetails?.searchedProject?.basicDetails?.projectDesc
            },
        ]
    }
    
    // const cardState = {
    //     "WORKS_ESTIMATE_TYPE": "Original Estimate",
    //     "WORKS_PROJECT_ID": projectData?.projectDetails?.searchedProject?.basicDetails?.projectId,
    //     "ESTIMATE_PROPOSAL_DATE": Digit.DateUtils.ConvertEpochToDate(projectData?.projectDetails?.searchedProject?.basicDetails?.projectProposalDate),
    //     "ESTIMATE_PROJECT_NAME": projectData?.projectDetails?.searchedProject?.basicDetails?.projectName,
    //     "PROJECT_DESC": projectData?.projectDetails?.searchedProject?.basicDetails?.projectDesc
    // }
    
    const history = useHistory()

    const [sessionFormData, setSessionFormData, clearSessionFormData] = EstimateSession;

    const { mutate: EstimateMutation } = Digit.Hooks.works.useCreateEstimateNew("WORKS");


    const [showModal, setShowModal] = useState(false);

    const rolesForThisAction = "ESTIMATE_VERIFIER" //hardcoded for now
    const [config, setConfig] = useState({});
    const [approvers, setApprovers] = useState([]);
    const [selectedApprover, setSelectedApprover] = useState({});

    // const [department, setDepartment] = useState([]);
    // const [selectedDept, setSelectedDept] = useState({})

    // const [designation, setDesignation] = useState([]);
    // const [selectedDesignation, setSelectedDesignation] = useState({})

    const [inputFormData,setInputFormData] = useState(sessionFormData)

    // const estimateFormConfig = createEstimateConfig()
    const tenant = Digit.ULBService.getStateId();
    const moduleName = Digit.Utils.getConfigModuleName()
    const { isLoading: isConfigLoading, data: estimateFormConfig } = Digit.Hooks.useCustomMDMS(
        tenant,
        moduleName,
        [
            {
                "name": "CreateEstimateConfig"
            }
        ],
        {
            select:(data)=> {
                return data?.[moduleName]?.CreateEstimateConfig?.[0]
            }
        }
    );

    const onFormSubmit = async (_data) => {
        
        //added this totalEst amount logic here because setValues in pageComponents don't work
        //after setting the value, in consequent renders value changes to undefined
        //check TotalEstAmount.js
            let totalNonSor = _data?.nonSORTablev1?.reduce((acc, row) => {
                let amountNonSor = parseFloat(row?.estimatedAmount)
                amountNonSor = amountNonSor ? amountNonSor : 0
                return amountNonSor + parseFloat(acc)
            }, 0)
            totalNonSor = totalNonSor ? totalNonSor : 0
            let totalOverHeads = _data?.overheadDetails?.reduce((acc, row) => {
                let amountOverheads = parseFloat(row?.amount)
                amountOverheads = amountOverheads ? amountOverheads : 0
                return amountOverheads + parseFloat(acc)
            }, 0)
            totalOverHeads = totalOverHeads ? totalOverHeads : 0
            _data.totalEstimateAmount =  totalNonSor + totalOverHeads

        let totalLabourAndMaterial = parseInt(_data.analysis.labour) + parseInt(_data.analysis.material)
        //here check totalEst amount should be less than material+labour
        
        if (_data.totalEstimateAmount < totalLabourAndMaterial )   {
            setShowToast({ warning: true, label: "ERR_ESTIMATE_AMOUNT_MISMATCH" })
            return
        } 
            

        setInputFormData((prevState) => _data)
        //first do whatever processing you want on form data then pass it over to modal's onSubmit function
        
        setShowModal(true);
    };
    const onModalSubmit = async (_data) => {
        
        const completeFormData = {
            ..._data,
            ...inputFormData,
            selectedApprover,
            // selectedDept,
            // selectedDesignation
        }
        // setSessionFormData(completeFormData)
        

        const payload = createEstimatePayload(completeFormData, projectData)
        setShowModal(false);
        
        

        await EstimateMutation(payload, {
            onError: async (error, variables) => {
                setShowToast({ warning: true, label: error?.response?.data?.Errors?.[0].message ? error?.response?.data?.Errors?.[0].message : error });
                setTimeout(() => {
                    setShowToast(false);
                }, 5000);
            },
            onSuccess: async (responseData, variables) => {
                clearSessionFormData();
                const state = {
                    header: t("WORKS_ESTIMATE_RESPONSE_CREATED_HEADER"),
                    id: responseData?.estimates[0]?.estimateNumber,
                    info: t("ESTIMATE_ESTIMATE_NO"),
                    // message: t("WORKS_ESTIMATE_RESPONSE_MESSAGE_CREATE", { department: t(`ES_COMMON_${responseData?.estimates[0]?.executingDepartment}`) }),
                    links: [
                        {
                            name: t("WORKS_GOTO_ESTIMATE_INBOX"),
                            redirectUrl: `/${window.contextPath}/employee/estimate/inbox`,
                            code: "",
                            svg: "GotoInboxIcon",
                            isVisible: true,
                            type: "inbox",
                        }
                    ],
                }
                
                history.push(`/${window?.contextPath}/employee/estimate/response`, state);
                
            },
        });
    }

    // const { isLoading: mdmsLoading, data: mdmsData, isSuccess: mdmsSuccess } = Digit.Hooks.useCustomMDMS(
    //     Digit.ULBService.getCurrentTenantId(),
    //     "common-masters",
    //     [
    //         {
    //             "name": "Designation"
    //         },
    //         {
    //             "name": "Department"
    //         }
    //     ]
    // );

    // mdmsData?.["common-masters"]?.Designation?.map(designation => {
    //     designation.i18nKey = `ES_COMMON_DESIGNATION_${designation?.name}`
    // })

    // mdmsData?.["common-masters"]?.Department?.map(department => {
    //     department.i18nKey = `ES_COMMON_${department?.code}`
    // })
    // useEffect(() => {
    //     setDepartment(mdmsData?.["common-masters"]?.Department)
    //     setDesignation(mdmsData?.["common-masters"]?.Designation)
    // }, [mdmsData]);


    // const { isLoading: approverLoading, isError, error, data: employeeDatav1 } = Digit.Hooks.hrms.useHRMSSearch({ designations: selectedDesignation?.code, departments: selectedDept?.code, roles: rolesForThisAction, isActive: true }, Digit.ULBService.getCurrentTenantId(), null, null, { enabled: !!(selectedDept || selectedDesignation) });
    const { isLoading: approverLoading, isError, error, data: employeeDatav1 } = Digit.Hooks.hrms.useHRMSSearch({ roles: rolesForThisAction, isActive: true }, Digit.ULBService.getCurrentTenantId(), null, null, { enabled:true });


    employeeDatav1?.Employees.map(emp => emp.nameOfEmp = emp?.user?.name || "NA")

    useEffect(() => {
        setApprovers(employeeDatav1?.Employees?.length > 0 ? employeeDatav1?.Employees.filter(emp => emp?.nameOfEmp !== "NA") : [])
    }, [employeeDatav1])
    useEffect(() => {

        setConfig(
            getModalConfig({
                t,
                approvers,
                selectedApprover,
                setSelectedApprover,
                approverLoading,
                // designation,
                // selectedDesignation,
                // setSelectedDesignation,
                // department,
                // selectedDept,
                // setSelectedDept,
            })
        )

    }, [approvers])

    
    if(isConfigLoading){
        return <Loader />
    }
  return (
    <Fragment>
          {showModal && <WorkflowModal
              closeModal={() => setShowModal(false)}
              onSubmit={onModalSubmit}
              config={config}
              sessionFormData={sessionFormData}
              setSessionFormData={setSessionFormData}
          />
          }
        <Header styles={{ marginLeft: "14px" }}>{t("ACTION_TEST_CREATE_ESTIMATE")}</Header>
        {/* Will fetch projectId from url params and do a search for project to show the below data in card while integrating with the API  */}
        {isLoading ?<Loader />:<Card styles={{ marginLeft: "14px" }}>
            <StatusTable>
                {cardState.values.map((value)=>{
                    return (
                        <Row key={t(value.title)} label={`${t(value.title)}:`} text={value.value} />
                    )
                })}
            </StatusTable>
        </Card>}
        {/* {isLoading? <Loader/>: <ViewDetailsCard cardState={cardState} t={t} />} */}
        <FormComposer
            label={"ACTION_TEST_CREATE_ESTIMATE"}
            config={estimateFormConfig?.form.map((config) => {
                return {
                    ...config,
                    body: config?.body.filter((a) => !a.hideInEmployee),
                };
            })}
            onSubmit={onFormSubmit}
            submitInForm={false}
            fieldStyle={{ marginRight: 0 }}
            inline={false}
            // className="card-no-margin"
            defaultValues={estimateFormConfig?.defaultValues}
            // defaultValues = {tempDefault}
            showWrapperContainers={false}
            isDescriptionBold={false}
            noBreakLine={true}
            showMultipleCardsWithoutNavs={false}
            showMultipleCardsInNavs={false}
            horizontalNavConfig={configNavItems}
            showFormInNav={true}  
            showNavs={true}
            sectionHeadStyle={{marginTop:"2rem"}}  
        />
          {showToast && (
              <Toast
                  error={showToast.error}
                  warning={showToast.warning}
                  label={t(showToast.label)}
                  onClose={() => {
                      setShowToast(null);
                  }}
                  isDleteBtn={true}
              />
          )}
    </Fragment>
  )
}

export default CreateEstimate