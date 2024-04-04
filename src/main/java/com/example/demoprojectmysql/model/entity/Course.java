package com.example.demoprojectmysql.model.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "COURSE")
@Data
public class Course extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME", length = 50, unique = true, nullable = false)
    private String courseName;

    @Column(name = "PRICE", nullable = false)
    private int price;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private CourseStatus Status;

    @Column(name = "COURSE_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private CourseType courseType;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "COMPANY_ID") // Tên cột của khoá ngoại trong BD
    private Company company;


}
