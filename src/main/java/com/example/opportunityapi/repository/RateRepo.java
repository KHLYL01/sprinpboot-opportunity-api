package com.example.opportunityapi.repository;

import com.example.opportunityapi.model.entity.CompanyProfile;
import com.example.opportunityapi.model.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RateRepo extends JpaRepository<Rate, Integer> {
    List<Rate> findAllByCompanyProfile_Id(int id);
}
