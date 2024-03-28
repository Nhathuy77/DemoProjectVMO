package com.example.demoprojectmysql.service.impl;



import com.example.demoprojectmysql.model.dto.CompanyCreateDTO;
import com.example.demoprojectmysql.model.dto.CompanyUpdateDTO;

import com.example.demoprojectmysql.model.entity.Company;
import com.example.demoprojectmysql.repository.Companyrepository;
import com.example.demoprojectmysql.service.ICompanyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class CompanyService implements ICompanyService {
    @Autowired
    private Companyrepository companyrepository;
    @Override
    public List<Company> getAll() {
        return companyrepository.findAll();
    }

    @Override
    public Company getById(int id) {
        Optional<Company> optionalCompany = companyrepository.findById(id);
        if (optionalCompany.isPresent()){
            return optionalCompany.get();
        }
        return null;
    }
    @Override
    public Company create(CompanyCreateDTO dto) {
        Company company = new Company();
        BeanUtils.copyProperties(dto, company);
        return companyrepository.save(company);
    }
    @Override
    public Company update(CompanyUpdateDTO dto) {
        Optional<Company> optionalCompany = companyrepository.findById(dto.getId());
        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            BeanUtils.copyProperties(dto, company);
            return companyrepository.save(company);
        }
        return null;
    }

    @Override
    public Company delete(int id) {
        companyrepository.deleteById(id);
        return null;

    }
}
