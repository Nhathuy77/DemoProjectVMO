package com.example.demoprojectmysql.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreateDTO {
    //    private int id;
    @NotBlank(message = "Tên người dùng không được để trống")
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String information;


}
