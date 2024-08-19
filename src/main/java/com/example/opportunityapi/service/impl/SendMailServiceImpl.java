package com.example.opportunityapi.service.impl;

import com.example.opportunityapi.service.SendMailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendMailServiceImpl implements SendMailService {


    private final JavaMailSender javaMailSender;

//    @Value("${spring.mail.username}")
//    private String fromEmailId;

    @Override
    public void sendMail(String receiver, String body, String subject) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("opportunity-api");
        simpleMailMessage.setTo(receiver);
        simpleMailMessage.setText(body);
        simpleMailMessage.setSubject(subject);

        javaMailSender.send(simpleMailMessage);
    }
}
