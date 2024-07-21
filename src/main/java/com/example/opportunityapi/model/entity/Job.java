package com.example.opportunityapi.model.entity;

import com.example.opportunityapi.model.enums.Experience;
import com.example.opportunityapi.model.enums.Gender;
import com.example.opportunityapi.model.enums.JopType;
import com.example.opportunityapi.model.enums.Nationality;
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
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String description;

    private double age;

    private Nationality nationality;

    private Gender gender;

    private JopType jopType;

    private Experience experience;

    private boolean online;

    private String url;

    private LocalDateTime expiryDate;

    @ManyToOne
    @JoinColumn(name = "company_profile_id")
    private CompanyProfile companyProfile;

    @ManyToOne
    @JoinColumn(name = "locations_id")
    private Locations locations;

    @ManyToOne
    @JoinColumn(name = "job_sub_category_id")
    private JobSubCategory jobSubCategory;

    @CreationTimestamp
    private LocalDateTime createdDate;
}
