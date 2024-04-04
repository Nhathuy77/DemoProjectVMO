package com.example.demoprojectmysql.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String country;
    private Integer telephone;

}


