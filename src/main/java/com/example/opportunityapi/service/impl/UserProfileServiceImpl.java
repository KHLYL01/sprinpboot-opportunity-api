package com.example.opportunityapi.service.impl;

import com.example.opportunityapi.model.dto.AddUserProfileDto;
import com.example.opportunityapi.model.dto.UserProfileDto;
import com.example.opportunityapi.model.entity.User;
import com.example.opportunityapi.model.entity.UserProfile;
import com.example.opportunityapi.model.mapper.UserProfileMapper;
import com.example.opportunityapi.repository.UserProfileRepo;
import com.example.opportunityapi.repository.UserRepo;
import com.example.opportunityapi.service.ImageService;
import com.example.opportunityapi.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {


    private final UserProfileRepo repo;
    private final UserRepo userRepo;

    private final UserProfileMapper mapper;

    private final ImageService imageService;

    @Override
    public List<UserProfileDto> findAll() {
        return mapper.toDtos(repo.findAll());
    }

    @Override
    public UserProfileDto add(AddUserProfileDto dto) throws IOException {

        String imageUrl = imageService.uploadImage(dto.getImageFile());
        User user = userRepo.findById(dto.getUserId()).get();

        UserProfile userProfile = mapper.toEntity(dto);
        userProfile.setUser(user);

        userProfile.setImage_url(imageUrl);

        UserProfile saved = repo.save(userProfile);

        return mapper.toDto(saved);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
