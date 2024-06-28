package com.example.opportunityapi.model.dto;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
public class UserLoginDto {

    @Email(message = "email is invalid formate xyz@gmail.com")
    private String email;

    //    @Min(value = 8, message = "password is lower than 8 letters")
    private String password;

}
