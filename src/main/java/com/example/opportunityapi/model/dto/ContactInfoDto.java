package com.example.opportunityapi.model.dto;

import com.example.opportunityapi.model.entity.FreeOpportunity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
public class ContactInfoDto {

    private int id;

    private String name;

    private String url;

    private FreeOpportunity freeOpportunity;

    private LocalDateTime createdDate;

}
