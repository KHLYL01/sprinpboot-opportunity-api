package com.example.opportunityapi.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
public class JobSearchDto {
    private String title;
    private String gender;
    private String nationality;
    private String jobType;
    private String experience;
    private String online;
    private String jobCategoryName;
}
