package com.example.opportunityapi.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "company_profile_id")
    private CompanyProfile companyProfile;

    private double rate;

    @CreationTimestamp
    private LocalDateTime createdDate;

}
