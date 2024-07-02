package com.example.opportunityapi.model.mapper;


import com.example.opportunityapi.model.dto.AddUserProfileDto;
import com.example.opportunityapi.model.dto.UserProfileDto;
import com.example.opportunityapi.model.entity.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserProfileMapper {

    public List<UserProfileDto> toDtos(List<UserProfile> entitys) {
        return entitys.stream().map(this::toDto).collect(Collectors.toList());
    }

    public UserProfileDto toDto(UserProfile entity) {
        return UserProfileDto.builder()
                .id(entity.getId())
                .userId(entity.getUser().getId())
                .name(entity.getUser().getName())
                .age(entity.getAge())
                .city(entity.getCity())
                .nationality(entity.getNationality())
                .country(entity.getCountry())
                .createdDate(entity.getCreatedDate())
                .educational_level(entity.getEducational_level())
                .gender(entity.getGender())
                .image_url(entity.getImage_url())
                .listOfOpportunity(entity.getListOfOpportunity())
                .specialty(entity.getSpecialty())
                .build();
    }

    public UserProfile toEntity(AddUserProfileDto dto) {
        return UserProfile.builder()
                .age(dto.getAge())
                .city(dto.getCity())
                .country(dto.getCountry())
                .educational_level(dto.getEducational_level())
                .gender(dto.getGender())
                .nationality(dto.getNationality())
                .specialty(dto.getSpecialty())
                .build();
    }
}
