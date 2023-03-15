package digit.web.controllers;


import digit.web.models.BankAccountRequest;
import digit.web.models.BankAccountResponse;
import digit.web.models.BankAccountSearchRequest;
import digit.web.models.ErrorRes;
import digit.web.models.ErrorRes1;
    import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.util.*;

    import javax.validation.constraints.*;
    import javax.validation.Valid;
    import javax.servlet.http.HttpServletRequest;
        import java.util.Optional;
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2023-03-14T17:30:53.139+05:30[Asia/Kolkata]")
@Controller
    @RequestMapping("")
    public class BankaccountApiController{

        private final ObjectMapper objectMapper;

        private final HttpServletRequest request;

        @Autowired
        public BankaccountApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
        }

                @RequestMapping(value="/bankaccount/v1/_create", method = RequestMethod.POST)
                public ResponseEntity<BankAccountResponse> bankaccountV1CreatePost(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody BankAccountRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<BankAccountResponse>(objectMapper.readValue("{  \"pagination\" : {    \"offSet\" : 5.637376656633329,    \"limit\" : 59.621339166831824,    \"sortBy\" : \"sortBy\",    \"totalCount\" : 2.3021358869347655,    \"order\" : \"\"  },  \"bankAccounts\" : [ {    \"bankAccountDetails\" : [ {      \"additionalFields\" : { },      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"isPrimary\" : true,      \"accountType\" : \"Savings or Current or UPI or Wallet\",      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"tenantId\" : \"pb.amritsar\",      \"bankBranchIdentifier\" : {        \"code\" : \"code\",        \"type\" : \"type\",        \"additionalDetails\" : { }      },      \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",      \"accountNumber\" : \"accountNumber\",      \"isActive\" : true,      \"accountHolderName\" : \"XYZ Holdings\"    }, {      \"additionalFields\" : { },      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"isPrimary\" : true,      \"accountType\" : \"Savings or Current or UPI or Wallet\",      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"tenantId\" : \"pb.amritsar\",      \"bankBranchIdentifier\" : {        \"code\" : \"code\",        \"type\" : \"type\",        \"additionalDetails\" : { }      },      \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",      \"accountNumber\" : \"accountNumber\",      \"isActive\" : true,      \"accountHolderName\" : \"XYZ Holdings\"    } ],    \"additionalFields\" : { },    \"serviceCode\" : \"ORG, IND or something else\",    \"tenantId\" : \"pb.amritsar\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"referenceId\" : \"UUID Organisation or Individual\"  }, {    \"bankAccountDetails\" : [ {      \"additionalFields\" : { },      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"isPrimary\" : true,      \"accountType\" : \"Savings or Current or UPI or Wallet\",      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"tenantId\" : \"pb.amritsar\",      \"bankBranchIdentifier\" : {        \"code\" : \"code\",        \"type\" : \"type\",        \"additionalDetails\" : { }      },      \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",      \"accountNumber\" : \"accountNumber\",      \"isActive\" : true,      \"accountHolderName\" : \"XYZ Holdings\"    }, {      \"additionalFields\" : { },      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"isPrimary\" : true,      \"accountType\" : \"Savings or Current or UPI or Wallet\",      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"tenantId\" : \"pb.amritsar\",      \"bankBranchIdentifier\" : {        \"code\" : \"code\",        \"type\" : \"type\",        \"additionalDetails\" : { }      },      \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",      \"accountNumber\" : \"accountNumber\",      \"isActive\" : true,      \"accountHolderName\" : \"XYZ Holdings\"    } ],    \"additionalFields\" : { },    \"serviceCode\" : \"ORG, IND or something else\",    \"tenantId\" : \"pb.amritsar\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"referenceId\" : \"UUID Organisation or Individual\"  } ],  \"responseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", BankAccountResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<BankAccountResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<BankAccountResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/bankaccount/v1/_search", method = RequestMethod.POST)
                public ResponseEntity<BankAccountResponse> bankaccountV1SearchPost(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody BankAccountSearchRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<BankAccountResponse>(objectMapper.readValue("{  \"pagination\" : {    \"offSet\" : 5.637376656633329,    \"limit\" : 59.621339166831824,    \"sortBy\" : \"sortBy\",    \"totalCount\" : 2.3021358869347655,    \"order\" : \"\"  },  \"bankAccounts\" : [ {    \"bankAccountDetails\" : [ {      \"additionalFields\" : { },      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"isPrimary\" : true,      \"accountType\" : \"Savings or Current or UPI or Wallet\",      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"tenantId\" : \"pb.amritsar\",      \"bankBranchIdentifier\" : {        \"code\" : \"code\",        \"type\" : \"type\",        \"additionalDetails\" : { }      },      \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",      \"accountNumber\" : \"accountNumber\",      \"isActive\" : true,      \"accountHolderName\" : \"XYZ Holdings\"    }, {      \"additionalFields\" : { },      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"isPrimary\" : true,      \"accountType\" : \"Savings or Current or UPI or Wallet\",      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"tenantId\" : \"pb.amritsar\",      \"bankBranchIdentifier\" : {        \"code\" : \"code\",        \"type\" : \"type\",        \"additionalDetails\" : { }      },      \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",      \"accountNumber\" : \"accountNumber\",      \"isActive\" : true,      \"accountHolderName\" : \"XYZ Holdings\"    } ],    \"additionalFields\" : { },    \"serviceCode\" : \"ORG, IND or something else\",    \"tenantId\" : \"pb.amritsar\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"referenceId\" : \"UUID Organisation or Individual\"  }, {    \"bankAccountDetails\" : [ {      \"additionalFields\" : { },      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"isPrimary\" : true,      \"accountType\" : \"Savings or Current or UPI or Wallet\",      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"tenantId\" : \"pb.amritsar\",      \"bankBranchIdentifier\" : {        \"code\" : \"code\",        \"type\" : \"type\",        \"additionalDetails\" : { }      },      \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",      \"accountNumber\" : \"accountNumber\",      \"isActive\" : true,      \"accountHolderName\" : \"XYZ Holdings\"    }, {      \"additionalFields\" : { },      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"isPrimary\" : true,      \"accountType\" : \"Savings or Current or UPI or Wallet\",      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"tenantId\" : \"pb.amritsar\",      \"bankBranchIdentifier\" : {        \"code\" : \"code\",        \"type\" : \"type\",        \"additionalDetails\" : { }      },      \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",      \"accountNumber\" : \"accountNumber\",      \"isActive\" : true,      \"accountHolderName\" : \"XYZ Holdings\"    } ],    \"additionalFields\" : { },    \"serviceCode\" : \"ORG, IND or something else\",    \"tenantId\" : \"pb.amritsar\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"referenceId\" : \"UUID Organisation or Individual\"  } ],  \"responseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", BankAccountResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<BankAccountResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<BankAccountResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/bankaccount/v1/_update", method = RequestMethod.POST)
                public ResponseEntity<BankAccountResponse> bankaccountV1UpdatePost(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody BankAccountRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<BankAccountResponse>(objectMapper.readValue("{  \"pagination\" : {    \"offSet\" : 5.637376656633329,    \"limit\" : 59.621339166831824,    \"sortBy\" : \"sortBy\",    \"totalCount\" : 2.3021358869347655,    \"order\" : \"\"  },  \"bankAccounts\" : [ {    \"bankAccountDetails\" : [ {      \"additionalFields\" : { },      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"isPrimary\" : true,      \"accountType\" : \"Savings or Current or UPI or Wallet\",      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"tenantId\" : \"pb.amritsar\",      \"bankBranchIdentifier\" : {        \"code\" : \"code\",        \"type\" : \"type\",        \"additionalDetails\" : { }      },      \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",      \"accountNumber\" : \"accountNumber\",      \"isActive\" : true,      \"accountHolderName\" : \"XYZ Holdings\"    }, {      \"additionalFields\" : { },      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"isPrimary\" : true,      \"accountType\" : \"Savings or Current or UPI or Wallet\",      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"tenantId\" : \"pb.amritsar\",      \"bankBranchIdentifier\" : {        \"code\" : \"code\",        \"type\" : \"type\",        \"additionalDetails\" : { }      },      \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",      \"accountNumber\" : \"accountNumber\",      \"isActive\" : true,      \"accountHolderName\" : \"XYZ Holdings\"    } ],    \"additionalFields\" : { },    \"serviceCode\" : \"ORG, IND or something else\",    \"tenantId\" : \"pb.amritsar\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"referenceId\" : \"UUID Organisation or Individual\"  }, {    \"bankAccountDetails\" : [ {      \"additionalFields\" : { },      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"isPrimary\" : true,      \"accountType\" : \"Savings or Current or UPI or Wallet\",      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"tenantId\" : \"pb.amritsar\",      \"bankBranchIdentifier\" : {        \"code\" : \"code\",        \"type\" : \"type\",        \"additionalDetails\" : { }      },      \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",      \"accountNumber\" : \"accountNumber\",      \"isActive\" : true,      \"accountHolderName\" : \"XYZ Holdings\"    }, {      \"additionalFields\" : { },      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"isPrimary\" : true,      \"accountType\" : \"Savings or Current or UPI or Wallet\",      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"tenantId\" : \"pb.amritsar\",      \"bankBranchIdentifier\" : {        \"code\" : \"code\",        \"type\" : \"type\",        \"additionalDetails\" : { }      },      \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",      \"accountNumber\" : \"accountNumber\",      \"isActive\" : true,      \"accountHolderName\" : \"XYZ Holdings\"    } ],    \"additionalFields\" : { },    \"serviceCode\" : \"ORG, IND or something else\",    \"tenantId\" : \"pb.amritsar\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"referenceId\" : \"UUID Organisation or Individual\"  } ],  \"responseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", BankAccountResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<BankAccountResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<BankAccountResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

        }
