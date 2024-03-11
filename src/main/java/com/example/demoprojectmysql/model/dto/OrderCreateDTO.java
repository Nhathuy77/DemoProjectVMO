package com.example.demoprojectmysql.model.dto;

import lombok.Data;

@Data
public class OrderCreateDTO {
    private int courseId;
    private int accountId;
    private int quantity;

}
