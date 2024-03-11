package com.example.demoprojectmysql.model.dto;

import lombok.Data;

@Data
public class CompanyUpdateDTO {
    private int id;
    private String name;
    private String nickName;
    private String address;
    private String phone;
    private String email;
}
