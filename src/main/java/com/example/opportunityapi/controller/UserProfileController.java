package com.example.opportunityapi.controller;

import com.example.opportunityapi.model.dto.UpdateUserProfileDto;
import com.example.opportunityapi.service.UserProfileService;
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

    final private UserProfileService service;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable int id) {
        return ResponseEntity.ok(service.findByUserId(id));
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> add(@ModelAttribute UpdateUserProfileDto dto) throws IOException {
        return new ResponseEntity<>(service.update(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
