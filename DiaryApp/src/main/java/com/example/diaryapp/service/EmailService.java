//package com.example.diaryapp.service;
//
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmailService {
//    @Autowired
//    private JavaMailSender emailSender;
//
//    public void sendVerificationEmail(String to, String subject, String text) throws MessagingException {
//        MimeMessage message = emailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//
//        helper.setTo(to);
//        helper.setSubject(subject);
//        helper.setText(text, true);
//
//        emailSender.send(message);
//    }
//}
//
////
////import jakarta.mail.MessagingException;
////import jakarta.mail.internet.MimeMessage;
////import lombok.RequiredArgsConstructor;
////import org.springframework.mail.javamail.JavaMailSender;
////import org.springframework.mail.javamail.MimeMessageHelper;
////import org.springframework.stereotype.Service;
////
////@Service
////@RequiredArgsConstructor
////public class EmailService {
////    private final JavaMailSender mailSender;
////
////    public void sendEmail(String to, String subject, String text) {
////        MimeMessage message = mailSender.createMimeMessage();
////        try {
////            MimeMessageHelper helper = new MimeMessageHelper(message, true);
////            helper.setTo(to);
////            helper.setSubject(subject);
////            helper.setText(text, true);
////            mailSender.send(message);
////        } catch (MessagingException e) {
////            throw new RuntimeException("Failed to send email", e);
////        }
////    }
////}
