package com.example.demoprojectmysql.model.dto;

import com.example.demoprojectmysql.model.entity.CourseStatus;
import com.example.demoprojectmysql.model.entity.CourseType;
import lombok.Data;

@Data
public class SearchCourseRequest extends BaseRequest {
    private String courseName;
    private int minPrice;
    private int maxPrice;
    private CourseStatus status;
    private CourseType courseType;

}
