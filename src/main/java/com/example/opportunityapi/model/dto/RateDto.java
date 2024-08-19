package com.example.opportunityapi.model.dto;

import com.example.opportunityapi.model.entity.CompanyProfile;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Setter
@Getter
@Builder

public class RateDto {

    private int id;

    private int companyProfileId;

    private int userProfileId;

    private double rate;

    private LocalDateTime createdDate;

}
