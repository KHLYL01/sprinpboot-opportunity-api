package com.example.opportunityapi.service;

import com.example.opportunityapi.model.dto.AddRateDto;
import com.example.opportunityapi.model.dto.RateDto;

import java.util.List;

public interface RateService {

    List<RateDto> findAll();

    List<RateDto>  findAllByCompanyProfileId(int id);

    RateDto add(AddRateDto dto);

    RateDto update(AddRateDto dto,int id);

    void delete(int id);

}
