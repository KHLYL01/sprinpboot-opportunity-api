package com.example.opportunityapi.service;


import com.example.opportunityapi.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    //    List<UserDto> findAllUser();
    UserDetailsService userDetailsService();

    List<User> getAllDisableUser();

    @Transactional
    void updateById(int id);

    @Transactional
    void deleteById(int id);
}
