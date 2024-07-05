package com.example.opportunityapi.service.impl;

import com.example.opportunityapi.model.dto.UpdateUserProfileDto;
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
    public UserProfileDto findByUserId(int id) {
        return mapper.toDto(repo.findById(id).get());
    }

    @Override
    public UserProfileDto update(UpdateUserProfileDto dto) throws IOException {

        String imageUrl = imageService.uploadImage(dto.getImageFile());
//        User user = userRepo.findById(dto.getUserId()).get();

        UserProfile userProfile = repo.findByUser_Id(dto.getUserId());

        UserProfile userProfile1 = mapper.toEntity(dto, userProfile.getId());

        userProfile1.setImage_url(imageUrl);
        userProfile1.setUser(userProfile.getUser());

        UserProfile saved = repo.save(userProfile1);

        return mapper.toDto(saved);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
