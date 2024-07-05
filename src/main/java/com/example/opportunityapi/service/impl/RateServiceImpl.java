package com.example.opportunityapi.service.impl;

import com.example.opportunityapi.model.dto.AddRateDto;
import com.example.opportunityapi.model.dto.RateDto;
import com.example.opportunityapi.model.entity.Rate;
import com.example.opportunityapi.model.mapper.RateMapper;
import com.example.opportunityapi.repository.CompanyProfileRepo;
import com.example.opportunityapi.repository.RateRepo;
import com.example.opportunityapi.service.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {


    private final RateRepo repo;

    private final CompanyProfileRepo companyProfileRepo;

    private final RateMapper mapper;


    @Override
    public List<RateDto> findAll() {
        return mapper.toDtos(repo.findAll());
    }

    @Override
    public List<RateDto> findAllByCompanyProfileId(int id) {
        return mapper.toDtos(repo.findAllByCompanyProfile_Id(id));
    }

    @Override
    public RateDto add(AddRateDto dto) {
        Rate rate = Rate.builder()
                .rate(dto.getRate())
                .companyProfile(companyProfileRepo.findById(dto.getCompanyProfileId()).get())
                .build();

        Rate saved = repo.save(rate);

        return mapper.toDto(saved);
    }


    @Override
    public RateDto update(AddRateDto dto, int id) {

        Rate rate = repo.findById(id).get();

        rate.setRate(dto.getRate());

        Rate saved = repo.save(rate);

        return mapper.toDto(saved);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
