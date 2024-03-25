package com.example.demoprojectmysql.config.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@JsonIgnoreProperties({"stackTrace", "cause", "suppressed", "localizedMessage"})
@NoArgsConstructor
public class CustomException extends RuntimeException {
    private Instant timestamp; // thời gian xảy ra lỗi
    private int status; // Trạng thái, mã lỗi
    private String message; // Nguyên nhân xảy ra lỗi
    private String path; // api lỗi

    public CustomException( int status, String message) {
        this.message = message;
        this.status = status;
        this.timestamp = Instant.now();
    }
    public CustomException(ErrorResponseEnum errorResponseEnum) {
        this.status = errorResponseEnum.status;
        this.message = errorResponseEnum.message;
        this.timestamp = Instant.now();
    }
    public CustomException(int status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
    }

    }

