package com.example.demoprojectmysql.controller;


import com.example.demoprojectmysql.model.dto.AccountCreateDTO;
import com.example.demoprojectmysql.model.dto.AccountUpdateDTO;
import com.example.demoprojectmysql.model.entity.Account;
import com.example.demoprojectmysql.model.entity.Log;
import com.example.demoprojectmysql.service.impl.AccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("api/v1/account")
@CrossOrigin("*")
public class AccountController {
//    private static final Logger logger = LogManager.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/get-all")

    public List<Account> getAll() {
        Log.info("Thông tin account");
        return accountService.getAll();
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create")
    public Account create(@RequestBody AccountCreateDTO dto) {
        return accountService.create(dto);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/update")
    public Account update(@RequestBody AccountUpdateDTO dto) {
        return accountService.update(dto);
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable int id) {
        Log.info("Thông tin account id");
        return accountService.getById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        accountService.delete(id);
    }
}
