package com.example.opportunityapi.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@Builder
public class UpdateUserProfileDto {

    private int userId;

    private String age;

    private String gender;

    private String educational_level;

    private String specialty;

    private String nationality;

    private String country;

    private String city;

    private MultipartFile imageFile;

}
