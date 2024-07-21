package com.example.opportunityapi.repository;

import com.example.opportunityapi.model.entity.ContactInfo;
import com.example.opportunityapi.model.entity.FreeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactInfoRepo extends JpaRepository<ContactInfo, Integer> {

    List<ContactInfo> findAllByFreeOpportunity_Id(int id);

}
