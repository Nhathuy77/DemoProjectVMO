package com.example.demoprojectmysql.controller;


import com.example.demoprojectmysql.service.impl.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("customers")
public class CustomerController {
    private CustomerService customerService;

    @PostMapping("/upload-customers-data")
    public ResponseEntity<?> uploadCustomersData(@RequestParam("file") MultipartFile file) {
        this.customerService.saveCustomersToDatabase(file);
        return ResponseEntity
                .ok(Map.of("Message", " Import thành công"));
    }
}