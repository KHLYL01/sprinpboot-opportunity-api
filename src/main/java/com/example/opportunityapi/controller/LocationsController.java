package com.example.opportunityapi.controller;

import com.example.opportunityapi.model.dto.AddLocationsDto;
import com.example.opportunityapi.service.LocationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/locations")
public class LocationsController {

    final private LocationsService service;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody AddLocationsDto dto) {
        return new ResponseEntity<>(service.add(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody AddLocationsDto dto, @PathVariable int id) {
        return new ResponseEntity<>(service.update(dto, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
