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

public class Jop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "company_profile_id")
    private CompanyProfile companyProfile;

    private double rate;

    @CreationTimestamp
    private LocalDateTime createdDate;
//+title
//+description
//+opportunity_criteria
//+apply_criteria
//+ expiry_date
//+documents
//+company_profile_id
//+address_id
//+sub_category_id
}
