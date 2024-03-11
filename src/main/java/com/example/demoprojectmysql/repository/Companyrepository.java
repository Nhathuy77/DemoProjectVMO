package com.example.demoprojectmysql.repository;


import com.example.demoprojectmysql.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Companyrepository extends JpaRepository<Company, Integer> { //<Đối tượng làm việc,kiểu dữ liệu Id>

}
