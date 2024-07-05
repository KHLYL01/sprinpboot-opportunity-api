package com.example.opportunityapi.model.mapper;


import com.example.opportunityapi.model.dto.AddRateDto;
import com.example.opportunityapi.model.dto.CompanyProfileDto;
import com.example.opportunityapi.model.dto.RateDto;
import com.example.opportunityapi.model.dto.UpdateCompanyProfileDto;
import com.example.opportunityapi.model.entity.CompanyProfile;
import com.example.opportunityapi.model.entity.Rate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RateMapper {

    public List<RateDto> toDtos(List<Rate> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public RateDto toDto(Rate entity) {
        return RateDto.builder()
                .id(entity.getId())
                .CompanyProfileId(entity.getCompanyProfile().getId())
                .rate(entity.getRate())
                .createdDate(entity.getCreatedDate())
                .build();
    }

}
