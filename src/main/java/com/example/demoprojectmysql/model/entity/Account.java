package com.example.demoprojectmysql.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ACCOUNT2")
@Data
public class Account extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "USERNAME", length = 50, unique = true, nullable = false)
    private String username;

    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "PASSWORD", length = 100, nullable = false)
    private String password;

    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Column(name = "ADDRESS", length = 200)
    private String address;

    @Column(name = "FULL_NAME", length = 100)
    private String fullName;

    @Column(name = "PHONE", length = 12)
    private String phone;

    @Column(name = "EMAIL", length = 100, unique = true, nullable = false)
    private String email;




}
