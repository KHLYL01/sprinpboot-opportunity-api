package com.example.opportunityapi.repository;

import com.example.opportunityapi.model.entity.JobCategory;
import com.example.opportunityapi.model.entity.JobSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSubCategoryRepo extends JpaRepository<JobSubCategory, Integer> {
    List<JobSubCategory> findAllByJobCategory_Id(int id);
}
