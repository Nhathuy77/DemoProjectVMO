package com.example.demoprojectmysql.model.entity;

import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@Data
@MappedSuperclass // để đánh giấu class này cũng là 1 phần trong các entity khác
public class Base {
    @Column(name = "CREATE_DATE")
    protected Date createDate;
    @Column(name = "CREATE_BY")
    protected String createBy;
    @Column(name = "UPDATE_DATE")
    protected Date updateDate;
    @Column(name = "UPDATE_BY")
    protected String updateBy;


    @PrePersist
    public void onPrePersist() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        this.createDate = new Date();
        this.createBy = username;
    }

    @PreUpdate
    public void onPreUpdate() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        this.updateDate = new Date();
        this.createBy = username;
    }
}
