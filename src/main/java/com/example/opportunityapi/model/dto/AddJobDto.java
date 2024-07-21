package com.example.opportunityapi.model.dto;

import com.example.opportunityapi.model.enums.Experience;
import com.example.opportunityapi.model.enums.Gender;
import com.example.opportunityapi.model.enums.JopType;
import com.example.opportunityapi.model.enums.Nationality;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@Builder
public class AddJobDto {

    private String title;

    private String description;

    private double age;

    private Nationality nationality;

    private Gender gender;

    private JopType jopType;

    private Experience experience;

    private boolean online;

    private String url;

    private LocalDateTime expiryDate;

    private int companyProfileId;

    private int locationId;

    private int jobSubCategoryId;

}
