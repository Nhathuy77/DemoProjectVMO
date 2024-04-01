package com.example.demoprojectmysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoProjectMySqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoProjectMySqlApplication.class, args);
        System.out.println("SERVER IS READY...");
    }

}
