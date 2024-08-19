package com.example.opportunityapi.controller;

import com.example.opportunityapi.model.dto.UpdateUserProfileDto;
import com.example.opportunityapi.model.dto.UpdateUserProfileRatingDto;
import com.example.opportunityapi.service.UserProfileService;
import com.example.opportunityapi.service.UserService;
import com.example.opportunityapi.service.impl.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admins")
public class AdminController {

    final private UserService service;

    @GetMapping
    public ResponseEntity<?> findAllDisable() {
        return ResponseEntity.ok(service.getAllDisableUser());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> add(@PathVariable int id) {
        service.updateById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
