package com.example.demoprojectmysql.controller;

import com.example.demoprojectmysql.model.dto.CompanyCreateDTO;
import com.example.demoprojectmysql.model.dto.CompanyUpdateDTO;
import com.example.demoprojectmysql.model.entity.Account;
import com.example.demoprojectmysql.model.entity.Company;
import com.example.demoprojectmysql.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/get-all")
    public List<Company> getAll() {
        return companyService.getAll();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{id}")
    public Company getById(@PathVariable int id) {
        return companyService.getById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create")
    public Company create(@RequestBody CompanyCreateDTO dto) {
        return companyService.create(dto);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/update")
    public Company update(@RequestBody CompanyUpdateDTO dto) {
        return companyService.update(dto);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        companyService.delete(id);
    }

}