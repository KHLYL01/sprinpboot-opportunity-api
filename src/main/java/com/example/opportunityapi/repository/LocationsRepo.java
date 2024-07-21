package com.example.opportunityapi.repository;

import com.example.opportunityapi.model.entity.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationsRepo extends JpaRepository<Locations, Integer> {
}
