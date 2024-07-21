package com.example.opportunityapi.repository;

import com.example.opportunityapi.model.entity.JobCategory;
import com.example.opportunityapi.model.entity.JobSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSubCategoryRepo extends JpaRepository<JobSubCategory, Integer> {
}
