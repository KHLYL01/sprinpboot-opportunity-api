package com.example.opportunityapi.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String country;
    
    private String city;

    @CreationTimestamp
    private LocalDateTime createdDate;

}
