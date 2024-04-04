package com.example.demoprojectmysql.configuration;

import com.example.demoprojectmysql.repository.Companyrepository;
import com.example.demoprojectmysql.service.ICompanyService;
import com.example.demoprojectmysql.service.impl.CompanyService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class Configuration {
    @Bean
    public ICompanyService iCompanyService(Companyrepository companyrepository){
        return new CompanyService(companyrepository);
    }


}
