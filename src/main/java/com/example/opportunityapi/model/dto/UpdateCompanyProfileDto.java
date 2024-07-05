package com.example.opportunityapi.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UpdateCompanyProfileDto {

    private int userId;

    private String scope;

}
