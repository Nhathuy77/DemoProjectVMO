package com.example.demoprojectmysql.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRegisterDTO {
        @NotBlank(message = "Tên người dùng không được để trống")
        private String username;
        private String password;
        private String email;

    }
