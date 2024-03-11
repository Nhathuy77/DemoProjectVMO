package com.example.demoprojectmysql.model.dto;

import lombok.Data;

@Data
public class CompanyCreateDTO {
//    @NotBlank(message = "Tên người dùng không được để trống")


//    private int id;
    private String name;
    private String nickName;
    private String address;
    private String phone;
    private String email;






}
