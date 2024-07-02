package com.example.opportunityapi.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
public class UserProfileDto {

    private int id;

    private int userId;

    private String name;
    
    private String age;

    private String gender;

    private String educational_level;

    private String specialty;

    private String nationality;

    private String country;

    private String city;

    private String image_url;

    private String listOfOpportunity;

    private LocalDateTime createdDate;

}
