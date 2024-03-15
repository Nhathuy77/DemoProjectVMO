package com.example.demoprojectmysql.model.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class AppExceptionDto {
    private Instant timestamp;
    private int status;
    private String message;
    private String path;

    public AppExceptionDto(String message, int status, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
        this.timestamp = Instant.now();
    }
}
