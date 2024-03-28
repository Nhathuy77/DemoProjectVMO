package com.example.demoprojectmysql.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "COMPANY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME", length = 200, unique = true, nullable = false)
    private String name;

    @Column(name = "NICK_NAME", length = 50, unique = true, nullable = false)
    private String nickName;

    @Column(name = "ADDRESS", length = 200)
    private String address;

    @Column(name = "PHONE", length = 12)
    private String phone;

    @Column(name = "EMAIL", length = 100, unique = true, nullable = false)
    private String email;

    }

