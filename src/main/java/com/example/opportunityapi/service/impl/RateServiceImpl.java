package com.example.opportunityapi.service.impl;

import com.example.opportunityapi.model.dto.*;
import com.example.opportunityapi.model.entity.CompanyProfile;
import com.example.opportunityapi.model.entity.Job;
import com.example.opportunityapi.model.entity.JobSubCategory;
import com.example.opportunityapi.model.entity.Rate;
import com.example.opportunityapi.model.mapper.JobMapper;
import com.example.opportunityapi.model.mapper.RateMapper;
import com.example.opportunityapi.repository.CompanyProfileRepo;
import com.example.opportunityapi.repository.JobRepo;
import com.example.opportunityapi.repository.JobSubCategoryRepo;
import com.example.opportunityapi.repository.RateRepo;
import com.example.opportunityapi.service.JobService;
import com.example.opportunityapi.service.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {


    private final RateRepo repo;
    private final RateMapper mapper;


    @Override
    public List<RateDto> findAll() {
        return mapper.toDtos(repo.findAll());
    }

    @Override
    public List<RateDto> findAllByCompanyId(int id) {
        return mapper.toDtos(repo.findAllByCompanyProfileId(id));
    }


    @Override
    public RateDto add(AddRateDto dto) {
        Rate rate = mapper.toAddEntity(dto);
        return mapper.toDto(repo.save(rate));
    }


    @Override
    public RateDto update(AddRateDto dto, int id) {

        Rate rate = repo.findById(id).get();
        rate.setRate(dto.getRate());

        return mapper.toDto(repo.save(rate));
    }

}
