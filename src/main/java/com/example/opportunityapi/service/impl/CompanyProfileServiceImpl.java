package com.example.opportunityapi.service.impl;

import com.example.opportunityapi.model.dto.CompanyProfileDto;
import com.example.opportunityapi.model.dto.UpdateCompanyProfileDto;
import com.example.opportunityapi.model.dto.UpdateUserProfileDto;
import com.example.opportunityapi.model.dto.UserProfileDto;
import com.example.opportunityapi.model.entity.CompanyProfile;
import com.example.opportunityapi.model.entity.UserProfile;
import com.example.opportunityapi.model.mapper.CompanyProfileMapper;
import com.example.opportunityapi.model.mapper.UserProfileMapper;
import com.example.opportunityapi.repository.CompanyProfileRepo;
import com.example.opportunityapi.repository.UserProfileRepo;
import com.example.opportunityapi.repository.UserRepo;
import com.example.opportunityapi.service.CompanyProfileService;
import com.example.opportunityapi.service.ImageService;
import com.example.opportunityapi.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyProfileServiceImpl implements CompanyProfileService {


    private final CompanyProfileRepo repo;

    private final CompanyProfileMapper mapper;


    @Override
    public List<CompanyProfileDto> findAll() {
        return mapper.toDtos(repo.findAll());
    }

    @Override
    public CompanyProfileDto findByUserId(int id) {
        return mapper.toDto(repo.findById(id).get());
    }

    @Override
    public CompanyProfileDto update(UpdateCompanyProfileDto dto) {

        CompanyProfile companyProfile = repo.findByUser_Id(dto.getUserId());

        CompanyProfile companyProfile1 = mapper.toEntity(dto, companyProfile.getId());

        companyProfile1.setUser(companyProfile.getUser());

        CompanyProfile saved = repo.save(companyProfile1);

        return mapper.toDto(saved);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
