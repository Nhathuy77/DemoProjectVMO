package com.example.demoprojectmysql.service;

import com.example.demoprojectmysql.model.dto.CompanyCreateDTO;
import com.example.demoprojectmysql.model.dto.CompanyUpdateDTO;
import com.example.demoprojectmysql.model.entity.Company;

import java.util.List;

public interface ICompanyService {
    List<Company> getAll();
    Company getById(int id);
    Company create(CompanyCreateDTO dto); // thêm mới
    Company update(CompanyUpdateDTO dto);
    Company delete(int id);

}
