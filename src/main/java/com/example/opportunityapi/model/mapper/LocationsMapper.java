package com.example.opportunityapi.model.mapper;


import com.example.opportunityapi.model.dto.LocationsDto;
import com.example.opportunityapi.model.entity.Locations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationsMapper {

    public List<LocationsDto> toDtos(List<Locations> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public LocationsDto toDto(Locations entity) {
        return LocationsDto.builder()
                .id(entity.getId())
                .city(entity.getCity())
                .country(entity.getCountry())
                .createdDate(entity.getCreatedDate())
                .build();
    }

}
