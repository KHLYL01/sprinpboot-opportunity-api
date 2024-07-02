package com.example.opportunityapi.controller;

import com.example.opportunityapi.model.dto.AddUserProfileDto;
import com.example.opportunityapi.model.dto.UserLoginDto;
import com.example.opportunityapi.model.dto.UserRefreshTokenDto;
import com.example.opportunityapi.model.dto.UserRegisterDto;
import com.example.opportunityapi.service.UserProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profiles")
public class UserProfileController {

    final private UserProfileService userProfileService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(userProfileService.findAll());
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> add(@ModelAttribute AddUserProfileDto dto) throws IOException {
        return new ResponseEntity<>(userProfileService.add(dto),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        userProfileService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
