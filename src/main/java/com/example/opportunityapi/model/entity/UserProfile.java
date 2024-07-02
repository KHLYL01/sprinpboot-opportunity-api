package com.example.opportunityapi.model.entity;

import com.example.opportunityapi.model.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserProfile  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String age;

    private String gender;

    private String educational_level;

    private String specialty;

    private String nationality;

    private String country;

    private String city;

    private String image_url;

    private String listOfOpportunity;

    @CreationTimestamp
    private LocalDateTime createdDate;

}
