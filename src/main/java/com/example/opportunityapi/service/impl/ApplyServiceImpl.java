package com.example.opportunityapi.service.impl;

import com.example.opportunityapi.model.dto.*;
import com.example.opportunityapi.model.entity.Apply;
import com.example.opportunityapi.model.entity.FreeCategory;
import com.example.opportunityapi.model.entity.Job;
import com.example.opportunityapi.model.entity.UserProfile;
import com.example.opportunityapi.model.enums.ApplyStatus;
import com.example.opportunityapi.model.mapper.ApplyMapper;
import com.example.opportunityapi.model.mapper.FreeCategoryMapper;
import com.example.opportunityapi.repository.ApplyRepo;
import com.example.opportunityapi.repository.FreeCategoryRepo;
import com.example.opportunityapi.repository.JobRepo;
import com.example.opportunityapi.repository.UserProfileRepo;
import com.example.opportunityapi.service.ApplyService;
import com.example.opportunityapi.service.FreeCategoryService;
import com.example.opportunityapi.service.SendMailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplyServiceImpl implements ApplyService {


    private final ApplyRepo repo;
    private final JobRepo jobRepo;
    private final UserProfileRepo userProfileRepo;
    private final ApplyMapper mapper;
    private final SendMailService sendMailService;


    @Override
    public List<ApplyDto> findAll() {
        return mapper.toDtos(repo.findAll());
    }

    @Override
    public List<ApplyDto> findAllByUserProfileId(int id) {
        return mapper.toDtos(repo.findAllByUserProfile_Id(id));
    }

    @Override
    public List<ApplyDto> findAllByCompanyProfileId(int id) {
        return mapper.toDtos(repo.findAllByJob_CompanyProfile_IdOrderByStatus(id));
    }

    @Override
    public List<ApplyDto> findAllByStatus(ApplyStatus status) {
        return mapper.toDtos(repo.findAllByStatus(status));
    }


    @Override
    public ApplyDto add(AddApplyDto dto) {


        Job job = jobRepo.findById(dto.getJobId()).get();

        UserProfile userProfile = userProfileRepo.findById(dto.getUserProfileId()).get();

        Apply apply = Apply.builder()
                .userProfile(userProfile)
                .job(job)
                .status(ApplyStatus.REQUESTING)
                .build();

        Apply saved = repo.save(apply);

        return mapper.toDto(saved);
    }


    @Override
    public ApplyDto update(UpdateApplyDto dto, int id) {

        Apply apply = repo.findById(id).get();

        apply.setStatus(dto.getStatus());

        //ToDo notifications and Email
        if (dto.getStatus() == ApplyStatus.ACCEPTABLE) {
            String message = apply.getJob().getCompanyProfile().getUser().getName() + "'s company has accepted you for the ( " + apply.getJob().getTitle() + " ) job";
            sendMailService.sendMail(apply.getUserProfile().getUser().getEmail(), message, "Accepted Successfully");
        }
        if (dto.getStatus() == ApplyStatus.UNACCEPTABLE) {
            String message = apply.getJob().getCompanyProfile().getUser().getName() + "'s company has rejected your request,try again";
            sendMailService.sendMail(apply.getUserProfile().getUser().getEmail(), message, "Rejected Request");
        }

        Apply saved = repo.save(apply);

        return mapper.toDto(saved);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
