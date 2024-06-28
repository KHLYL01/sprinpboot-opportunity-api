package com.example.opportunityapi.model.dto;

import com.example.opportunityapi.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
public class UserRegisterDto {
    private String name;

    @Email(message = "email is invalid formate xyz@gmail.com")
    private String email;

    //    @Min(message = "password is lower than 8 letters", value = 8)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;

    private String phoneNumber;

    private Role role;
}