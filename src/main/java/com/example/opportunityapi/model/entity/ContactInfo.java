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

public class ContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String url;

    @ManyToOne
    @JoinColumn(name = "free_opportunity_id")
    private FreeOpportunity freeOpportunity;

    @CreationTimestamp
    private LocalDateTime createdDate;

}
