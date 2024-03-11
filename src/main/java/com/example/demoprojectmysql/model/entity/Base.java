package com.example.demoprojectmysql.model.entity;

import lombok.Data;

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
        this.createDate = new Date();
        this.createBy = "Huy Create";
    }

    @PreUpdate
    public void onPreUpdate() {
        this.updateDate = new Date();
        this.createBy = "Huy Update";
    }
}
