package com.example.opportunityapi.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
public class RateDto {

    private int id;

    private int CompanyProfileId;

    private double rate;

    private LocalDateTime createdDate;

}
