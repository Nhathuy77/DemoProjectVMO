package com.example.demoprojectmysql.model.dto;

import com.example.demoprojectmysql.model.entity.CourseStatus;
import lombok.Data;

@Data
public class CourseUpdateDTO {
    private int id;
    private String name;
    private int price;
    private CourseStatus Status;
}
