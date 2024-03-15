package com.example.demoprojectmysql.model.entity;


import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {// Biến thuộc tính này dùng để làm phân quyền trong Security
    USER, MANAGER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
