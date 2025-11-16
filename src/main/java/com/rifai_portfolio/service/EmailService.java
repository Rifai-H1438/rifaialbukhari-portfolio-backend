package com.rifai_portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendClientSubmissionMail(String toEmail, String name, String email, String description) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("New Client Submission from " + name);
        message.setText("Name: " + name + "\nEmail: " + email + "\nDescription: " + description);
        mailSender.send(message);
    }
}
