package com.example.opportunityapi.repository;

import com.example.opportunityapi.model.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<Job, Integer> {

    List<Job> findAllByCompanyProfile_IdOrderByCreatedDateDesc(int id);

    @Query("SELECT j FROM Job j WHERE " +
            "(:title IS NULL OR j.title LIKE %:title%) AND " +
            "(:gender IS NULL OR j.gender = :gender) AND " +
            "(:jopType IS NULL OR j.jopType = :jopType) AND " +
            "(:nationality IS NULL OR j.nationality = :nationality) AND " +
            "(:experience IS NULL OR j.experience = :experience) AND " +
            "(:online IS NULL OR j.online = :online) AND " +
            "(:jobCategoryName IS NULL OR j.jobSubCategory.jobCategory.name = :jobCategoryName)"
    )
    List<Job> searchJob(
            @Param("title") String title,
            @Param("gender") String gender,
            @Param("nationality") String nationality,
            @Param("jopType") String jopType,
            @Param("experience") String experience,
            @Param("online") String online,
            @Param("jobCategoryName") String jobCategoryName
    );
}
