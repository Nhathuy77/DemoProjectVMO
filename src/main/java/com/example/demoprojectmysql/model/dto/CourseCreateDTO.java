package com.example.demoprojectmysql.model.dto;

import com.example.demoprojectmysql.model.entity.CourseStatus;
import com.example.demoprojectmysql.model.entity.CourseType;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CourseCreateDTO {
    @NotBlank(message = "Tên khóa học không được để trống")
    private String name;
    private int price;
    private CourseStatus Status;
    private CourseType courseType;
}
