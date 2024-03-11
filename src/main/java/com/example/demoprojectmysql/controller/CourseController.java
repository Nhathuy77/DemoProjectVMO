package com.example.demoprojectmysql.controller;
import com.example.demoprojectmysql.model.dto.*;
import com.example.demoprojectmysql.model.entity.Company;
import com.example.demoprojectmysql.model.entity.Course;
import com.example.demoprojectmysql.service.impl.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
    @RestController
    @RequestMapping("/api/v1/course")
    public class CourseController {
        @Autowired
        private CourseService courseService;

        @GetMapping("/get-all")
        public List<Course> getAll() {
            return courseService.getAll();
        }

        @GetMapping("{id}")
        public Course getById(@PathVariable int id) {
            return courseService.getById(id);
        }

        @PostMapping("/create")
        public Course create(@RequestBody CourseCreateDTO dto) {
            return courseService.create(dto);
        }

        @PostMapping("/search")
        public Page<Course> search(@RequestBody SearchCourseRequest request) {
            return courseService.search(request);
        }

        @PutMapping("/update")
        public Course update(@RequestBody CourseUpdateDTO dto) {
            return courseService.update(dto);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable int id) {
            courseService.delete(id);
        }

    }

