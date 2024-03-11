package com.example.demoprojectmysql.service;
import com.example.demoprojectmysql.model.dto.BaseRequest;
import com.example.demoprojectmysql.model.dto.CourseCreateDTO;
import com.example.demoprojectmysql.model.dto.CourseUpdateDTO;
import com.example.demoprojectmysql.model.dto.SearchCourseRequest;
import com.example.demoprojectmysql.model.entity.Account;
import com.example.demoprojectmysql.model.entity.Course;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICourseService {
    List<Course> getAll();
    Page<Course> search(SearchCourseRequest request);
    Course getById(int id);
    Course create(CourseCreateDTO dto); // thêm mới
    Course update(CourseUpdateDTO dto);
    Course delete(int id);
}
