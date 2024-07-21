package com.example.opportunityapi.repository;

import com.example.opportunityapi.model.entity.FreeOpportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreeOpportunityRepo extends JpaRepository<FreeOpportunity, Integer> {
}
