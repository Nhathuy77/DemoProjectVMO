package com.example.demoprojectmysql.service.impl;

import com.example.demoprojectmysql.config.exception.CustomException;
import com.example.demoprojectmysql.service.IMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class MailSenderService implements IMailSender {
    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendMessageWithAttachment(String to, String subject, String text) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("noreply@baeldung.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true); // text có thể để dạng html = true
//            FileSystemResource file
//                    = new FileSystemResource(new File(pathToAttachment)); // pathToAttachment: Đường dẫn tới file cần gửi
//            helper.addAttachment("Invoice", file);// File có thể là hình ảnh hoặc pdf,...
            emailSender.send(message);
        } catch (Exception e){
            throw new CustomException(500, e.getMessage());
        }

    }
}
