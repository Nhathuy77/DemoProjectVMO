package com.example.demoprojectmysql.model.entity;

import com.example.demoprojectmysql.model.dto.AccountCreateDTO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ACCOUNT2")
@Getter // Sinh ra các method getter
@Setter// Sinh ra các method setter
@NoArgsConstructor // Sinh ra hàm khởi tạo không tham số
@AllArgsConstructor // Sinh ra hàm khởi tạo có tất cả các tham số
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

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    public Account(AccountCreateDTO createDto) {
        this.username = createDto.getUsername();
    }
}
