package com.example.opportunityapi.service;

import com.example.opportunityapi.model.dto.*;
import com.example.opportunityapi.model.enums.ApplyStatus;

import java.util.List;

public interface ApplyService {

    List<ApplyDto> findAll();

    List<ApplyDto> findAllByStatus(ApplyStatus status);

    ApplyDto add(AddApplyDto dto);

    ApplyDto update(UpdateApplyDto dto, int id);

    void delete(int id);

}
