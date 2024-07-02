package com.example.opportunityapi.service;

import com.example.opportunityapi.model.dto.*;

import java.io.IOException;
import java.util.List;

public interface UserProfileService {

    List<UserProfileDto> findAll();

    UserProfileDto add(AddUserProfileDto dto) throws IOException;

    void delete(int id);

}
