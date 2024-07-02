package com.example.opportunityapi.controller;

import com.example.opportunityapi.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/images")
public class ImageController {

    private final ImageService imageService;


    @GetMapping("/{imageName}")
    public ResponseEntity<?> viewImage(@PathVariable String imageName) throws IOException {
        return ResponseEntity.ok(imageService.viewImage(imageName));
    }
}
