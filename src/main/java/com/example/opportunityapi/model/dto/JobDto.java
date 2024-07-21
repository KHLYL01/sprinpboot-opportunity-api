package com.example.opportunityapi.model.dto;

import com.example.opportunityapi.model.entity.CompanyProfile;
import com.example.opportunityapi.model.entity.JobSubCategory;
import com.example.opportunityapi.model.entity.Locations;
import com.example.opportunityapi.model.enums.Experience;
import com.example.opportunityapi.model.enums.Gender;
import com.example.opportunityapi.model.enums.JopType;
import com.example.opportunityapi.model.enums.Nationality;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Setter
@Getter
@Builder
public class JobDto {

    private int id;

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

    private CompanyProfile companyProfile;

    private Locations locations;

    private JobSubCategory jobSubCategory;

    private LocalDateTime createdDate;

}
