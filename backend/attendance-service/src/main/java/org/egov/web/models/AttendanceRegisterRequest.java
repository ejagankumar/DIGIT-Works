package org.egov.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

/**
 * AttendanceRegisterRequest
 */
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2022-11-14T14:44:21.051+05:30")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendanceRegisterRequest {
    @JsonProperty("requestInfo")
    private Object requestInfo = null;

    @JsonProperty("attendanceRegister")
    private AttendanceRegister attendanceRegister = null;


}
