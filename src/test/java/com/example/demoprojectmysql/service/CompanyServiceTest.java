package com.example.demoprojectmysql.service;

import com.example.demoprojectmysql.model.dto.CompanyCreateDTO;
import com.example.demoprojectmysql.model.entity.Company;
import com.example.demoprojectmysql.repository.Companyrepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@WebMvcTest(ICompanyService.class)
public class CompanyServiceTest {
    @MockBean
    private Companyrepository companyrepository;

    @Autowired
    private ICompanyService iCompanyService;

    @Test
    public void testGetAll() {
        // Tạo danh sách các công ty giả mạo
        List<Company> mockCompanies = Arrays.asList(
                new Company(1, "công nghệ 1", "VMO1", "Ha Noi 1", "0987654321", "vmo1@gmail.com"),
                new Company(2, "công nghệ 2", "VMO2", "Ha Noi 2", "0987654322", "vmo2@gmail.com"),
                new Company(1, "công nghệ 3", "VMO3", "Ha Noi 3", "0987654323", "vmo3@gmail.com")
        );
        // Thiết lập behavior của mock repository
        Mockito.when(companyrepository.findAll()).thenReturn(mockCompanies);

        // Gọi phương thức getAll() của service
        List<Company> actualCompanies = iCompanyService.getAll();

        // Kiểm tra kết quả trả về từ service
        assertNotNull(actualCompanies);
        assertEquals(mockCompanies.size(), actualCompanies.size());
        assertEquals(mockCompanies, actualCompanies);
    }
}

