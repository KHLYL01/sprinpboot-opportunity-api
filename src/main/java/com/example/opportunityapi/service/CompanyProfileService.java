package com.example.opportunityapi.service;

import com.example.opportunityapi.model.dto.CompanyProfileDto;
import com.example.opportunityapi.model.dto.UpdateCompanyProfileDto;

import java.util.List;

public interface CompanyProfileService {

    List<CompanyProfileDto> findAll();

    CompanyProfileDto findByUserId(int id);

    CompanyProfileDto update(UpdateCompanyProfileDto dto);

    void delete(int id);

}
