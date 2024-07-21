package com.example.opportunityapi.service;

import com.example.opportunityapi.model.dto.AddJobCategoryDto;
import com.example.opportunityapi.model.dto.AddJobDto;
import com.example.opportunityapi.model.dto.JobCategoryDto;
import com.example.opportunityapi.model.dto.JobDto;

import java.util.List;

public interface JobService {

    List<JobDto> findAll();

    JobDto add(AddJobDto dto);

    JobDto update(AddJobDto dto, int id);

    void delete(int id);

}
