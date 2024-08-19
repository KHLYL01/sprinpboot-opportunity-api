package com.example.opportunityapi.model.mapper;


import com.example.opportunityapi.model.dto.UserDto;
import com.example.opportunityapi.model.dto.UserProfileDto;
import com.example.opportunityapi.model.dto.UserRegisterDto;
import com.example.opportunityapi.model.entity.User;
import com.example.opportunityapi.model.entity.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public List<UserDto> toDtos(List<User> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public UserDto toDto(User entity) {
        return UserDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .role(entity.getRole())
                .build();
    }

    public UserRegisterDto toRegisterDto(User entity) {
        return UserRegisterDto.builder()
                .name(entity.getName())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .role(entity.getRole())
                .build();
    }

    public User toEntity(UserRegisterDto dto) {
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(dto.getRole())
                .build();
    }



}
