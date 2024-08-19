package com.example.opportunityapi.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@Builder
public class AddRateDto {

    private int companyProfileId;

    private int userProfileId;

    private double rate;

}
