package com.example.opportunityapi.service.impl;

import com.example.opportunityapi.model.dto.AddContactInfoDto;
import com.example.opportunityapi.model.dto.ContactInfoDto;
import com.example.opportunityapi.model.entity.ContactInfo;
import com.example.opportunityapi.model.entity.FreeOpportunity;
import com.example.opportunityapi.model.mapper.ContactInfoMapper;
import com.example.opportunityapi.repository.ContactInfoRepo;
import com.example.opportunityapi.repository.FreeOpportunityRepo;
import com.example.opportunityapi.service.ContactInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactInfoServiceImpl implements ContactInfoService {


    private final ContactInfoRepo repo;
    private final FreeOpportunityRepo freeOpportunityRepo;
    private final ContactInfoMapper mapper;


    @Override
    public List<ContactInfoDto> findAll() {
        return mapper.toDtos(repo.findAll());
    }

    @Override
    public List<ContactInfoDto> findAllByFreeOpportunityId(int id) {
        return mapper.toDtos(repo.findAllByFreeOpportunity_Id(id));
    }


    @Override
    public ContactInfoDto add(AddContactInfoDto dto) {

        FreeOpportunity freeOpportunity = freeOpportunityRepo.findById(dto.getFreeOpportunityId()).get();

        ContactInfo contactInfo = mapper.toAddEntity(dto);

        contactInfo.setFreeOpportunity(freeOpportunity);

        ContactInfo saved = repo.save(contactInfo);

        return mapper.toDto(saved);
    }

    @Override
    public ContactInfoDto update(AddContactInfoDto dto, int id) {
        ContactInfo contactInfo = repo.findById(id).get();

        FreeOpportunity freeOpportunity = freeOpportunityRepo.findById(dto.getFreeOpportunityId()).get();

        ContactInfo mapperContactInfo = mapper.toAddEntity(dto);

        mapperContactInfo.setId(contactInfo.getId());
        mapperContactInfo.setCreatedDate(contactInfo.getCreatedDate());
        mapperContactInfo.setFreeOpportunity(freeOpportunity);

        ContactInfo saved = repo.save(mapperContactInfo);

        return mapper.toDto(saved);
    }


    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
