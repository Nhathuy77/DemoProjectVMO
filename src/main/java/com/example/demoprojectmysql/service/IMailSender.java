package com.example.demoprojectmysql.service;

public interface IMailSender {
    void sendMessageWithAttachment(String to, String subject, String text);
}
