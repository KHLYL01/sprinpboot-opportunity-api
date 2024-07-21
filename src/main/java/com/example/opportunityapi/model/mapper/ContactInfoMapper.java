package com.example.opportunityapi.model.mapper;


import com.example.opportunityapi.model.dto.AddContactInfoDto;
import com.example.opportunityapi.model.dto.AddReportDto;
import com.example.opportunityapi.model.dto.ContactInfoDto;
import com.example.opportunityapi.model.dto.FreeCategoryDto;
import com.example.opportunityapi.model.entity.ContactInfo;
import com.example.opportunityapi.model.entity.FreeCategory;
import com.example.opportunityapi.model.entity.Report;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactInfoMapper {

    public List<ContactInfoDto> toDtos(List<ContactInfo> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public ContactInfoDto toDto(ContactInfo entity) {
        return ContactInfoDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .freeOpportunity(entity.getFreeOpportunity())
                .url(entity.getUrl())
                .createdDate(entity.getCreatedDate())
                .build();
    }

    public ContactInfo toAddEntity(AddContactInfoDto dto) {
        return ContactInfo.builder()
                .name(dto.getName())
                .url(dto.getUrl())
                .build();
    }

}
