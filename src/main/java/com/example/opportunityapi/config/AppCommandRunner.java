//package com.example.opportunityapi.config;
//
//import com.example.fingerprint.model.dto.*;
//import com.example.fingerprint.model.entity.Role;
//import com.example.fingerprint.model.entity.User;
//import com.example.fingerprint.repository.EmployeeRepo;
//import com.example.fingerprint.repository.RoleRepo;
//import com.example.fingerprint.repository.UserRepo;
//import com.example.fingerprint.service.AuthService;
//import com.example.fingerprint.service.EmployeeService;
//import com.example.fingerprint.service.FingerPlaceService;
//import com.example.fingerprint.service.TimezoneService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Component
//@RequiredArgsConstructor
//public class AppCommandRunner implements CommandLineRunner {
//
//
//
//    @Transactional
//    @Override
//    public void run(String... args) {
//
//        if (roleRepo.findAll().isEmpty()) {
//
//        }
//
//        System.out.println("============================= Admin =============================");
//        System.out.println("Admin Token: " + adminResponse.getToken());
//        System.out.println("Admin ID: " + adminResponse.getId());
//        System.out.println("main Section ID: " + adminResponse.getMainSection().getId());
//        System.out.println("main Timezone: " + adminResponse.getTimezone().getCapital());
//        System.out.println("main Finger place: " + fingerPlace.getName());
//        System.out.println("============================= Manager ===========================");
//        System.out.println("Manager Token: " + managerResponse.getToken());
//        System.out.println("============================= Employee ==========================");
//        System.out.println("Employee Token: " + employeeResponse.getToken());
//
//    }
//}
