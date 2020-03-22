package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    @JsonProperty("mobile")
    private String mobileNumber;
}
