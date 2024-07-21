package com.example.opportunityapi.service;

import com.example.opportunityapi.model.dto.AddContactInfoDto;
import com.example.opportunityapi.model.dto.AddReportDto;
import com.example.opportunityapi.model.dto.ContactInfoDto;
import com.example.opportunityapi.model.dto.ReportDto;

import java.io.IOException;
import java.util.List;

public interface ContactInfoService {

    List<ContactInfoDto> findAll();

    List<ContactInfoDto> findAllByFreeOpportunityId(int id);

    ContactInfoDto add(AddContactInfoDto dto);

    ContactInfoDto update(AddContactInfoDto dto, int id);

    void delete(int id);
}
