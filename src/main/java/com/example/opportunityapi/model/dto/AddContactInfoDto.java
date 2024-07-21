package com.example.opportunityapi.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class AddContactInfoDto {

    private String name;

    private String url;

    private int freeOpportunityId;

}
