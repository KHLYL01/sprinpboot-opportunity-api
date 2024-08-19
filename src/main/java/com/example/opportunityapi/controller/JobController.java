package com.example.opportunityapi.controller;

import com.example.opportunityapi.model.dto.AddJobDto;
import com.example.opportunityapi.model.dto.JobSearchDto;
import com.example.opportunityapi.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/jobs")
public class JobController {

    final private JobService service;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/companyProfile/{id}")
    public ResponseEntity<?> findAllByJobProfileId(@PathVariable int id) {
        return ResponseEntity.ok(service.findAllByCompanyProfileId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return ResponseEntity.ok(service.findById(id));
    }


    @GetMapping("/search")
    public ResponseEntity<?> search(
            @RequestParam(required = false, name = "title") String title,
            @RequestParam(required = false, name = "gender") String gender,
            @RequestParam(required = false, name = "nationality") String nationality,
            @RequestParam(required = false, name = "jobType") String jobType,
            @RequestParam(required = false, name = "experience") String experience,
            @RequestParam(required = false, name = "online") String online,
            @RequestParam(required = false, name = "jobCategoryName") String jobCategoryName
    ) {
        return ResponseEntity.ok(
                service.search(
                        JobSearchDto.builder()
                                .title(title)
                                .gender(gender)
                                .jobType(jobType)
                                .nationality(nationality)
                                .experience(experience)
                                .online(online)
                                .jobCategoryName(jobCategoryName)
                                .build()
                )
        );
    }


    @PostMapping
    public ResponseEntity<?> add(@RequestBody AddJobDto dto) {
        return new ResponseEntity<>(service.add(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody AddJobDto dto, @PathVariable int id) {
        return new ResponseEntity<>(service.update(dto, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
