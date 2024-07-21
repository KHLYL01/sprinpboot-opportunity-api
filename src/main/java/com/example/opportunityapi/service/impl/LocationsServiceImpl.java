package com.example.opportunityapi.service.impl;

import com.example.opportunityapi.model.dto.AddLocationsDto;
import com.example.opportunityapi.model.dto.LocationsDto;
import com.example.opportunityapi.model.entity.Locations;
import com.example.opportunityapi.model.mapper.LocationsMapper;
import com.example.opportunityapi.repository.LocationsRepo;
import com.example.opportunityapi.service.LocationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationsServiceImpl implements LocationsService {


    private final LocationsRepo repo;
    private final LocationsMapper mapper;


    @Override
    public List<LocationsDto> findAll() {
        return mapper.toDtos(repo.findAll());
    }


    @Override
    public LocationsDto add(AddLocationsDto dto) {
        Locations location = Locations.builder()
                .city(dto.getCity())
                .country(dto.getCountry())
                .build();

        Locations saved = repo.save(location);

        return mapper.toDto(saved);
    }


    @Override
    public LocationsDto update(AddLocationsDto dto, int id) {

        Locations location = repo.findById(id).get();

        location.setCity(dto.getCity());
        location.setCountry(dto.getCountry());

        Locations saved = repo.save(location);

        return mapper.toDto(saved);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
