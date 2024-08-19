package com.example.opportunityapi.service.impl;

import com.example.opportunityapi.model.entity.CompanyProfile;
import com.example.opportunityapi.model.entity.User;
import com.example.opportunityapi.repository.CompanyProfileRepo;
import com.example.opportunityapi.repository.UserRepo;
import com.example.opportunityapi.service.SendMailService;
import com.example.opportunityapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepo userRepo;
    private final CompanyProfileRepo companyProfileRepo;
    private final SendMailService sendMailService;


    @Override
    public UserDetailsService userDetailsService() {
        return username -> userRepo.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found")
        );
    }

    @Override
    public List<User> getAllDisableUser() {
        return userRepo.findAllByEnableFalse();
    }

    @Override
    public void updateById(int id) {
        User user = userRepo.findById(id).get();
        user.setEnable(true);

        companyProfileRepo.save(CompanyProfile.builder()
                .user(user)
                .build());

        userRepo.save(user);

        sendMailService.sendMail(user.getEmail(), "Your account has been verified, You can now login", "Verified Successfully");
    }

    @Override
    public void deleteById(int id) {
        User user = userRepo.findById(id).get();
        userRepo.deleteById(id);
        sendMailService.sendMail(user.getEmail(), "Your account has been rejected, You can now login", "Verification Declined");

    }
}
