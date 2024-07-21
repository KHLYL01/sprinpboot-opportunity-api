package com.example.opportunityapi.service;

import com.example.opportunityapi.model.dto.AddLocationsDto;
import com.example.opportunityapi.model.dto.LocationsDto;

import java.util.List;

public interface LocationsService {

    List<LocationsDto> findAll();

    LocationsDto add(AddLocationsDto dto);

    LocationsDto update(AddLocationsDto dto, int id);

    void delete(int id);

}
