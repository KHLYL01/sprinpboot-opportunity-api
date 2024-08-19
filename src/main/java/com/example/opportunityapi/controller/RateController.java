package com.example.opportunityapi.controller;

import com.example.opportunityapi.model.dto.AddRateDto;
import com.example.opportunityapi.service.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rates")
public class RateController {

    final private RateService service;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/companyProfile/{id}")
    public ResponseEntity<?> findAllByCompanyProfileId(@PathVariable int id) {
        return ResponseEntity.ok(service.findAllByCompanyId(id));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody AddRateDto dto) {
        return new ResponseEntity<>(service.add(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody AddRateDto dto, @PathVariable int id) {
        return new ResponseEntity<>(service.update(dto, id), HttpStatus.CREATED);
    }

}
