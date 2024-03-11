package com.example.demoprojectmysql.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "`ORDER`")
@Data
public class Order extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ORDER_BY") // Tên cột của khoá ngoại trong BD
    private Account account;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "COURSE_ID") // Tên cột của khoá ngoại trong BD
    private Course course;

    @Column(name = "QUANTITY")
    private int quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS")
    private OrderStatus orderStatus;
}
