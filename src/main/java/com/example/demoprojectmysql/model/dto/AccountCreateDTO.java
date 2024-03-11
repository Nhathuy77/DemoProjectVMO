package com.example.demoprojectmysql.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class AccountCreateDTO {
//    private int id;
@NotBlank(message = "Tên người dùng không được để trống")
    private String username;
    private String password;
    private Date dateOfBirth;
    private String fullName;
    private String email;
    private String information;




}
