package com.example.demoprojectmysql.controller;

import com.example.demoprojectmysql.config.exception.CustomException;
import com.example.demoprojectmysql.config.exception.ErrorResponseEnum;
import com.example.demoprojectmysql.model.dto.AccountCreateDTO;
import com.example.demoprojectmysql.model.dto.AccountLoginResponse;
import com.example.demoprojectmysql.model.entity.Account;
import com.example.demoprojectmysql.model.entity.Role;
import com.example.demoprojectmysql.repository.AccountRepository;
import com.example.demoprojectmysql.utils.JWTTokenUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin("*")
@Validated
public class AuthController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private JWTTokenUtils jwtTokenUtils;
        @GetMapping("/login")
        public String login() {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String username = auth.getName();
            return "bạn đã đăng nhập thành công!"+ username;
        }

    @PostMapping("/register")
    public Account register(@RequestBody @Valid AccountCreateDTO createDto) {
        if (accountRepository.existsByUsername(createDto.getUsername())) {
            throw new CustomException(ErrorResponseEnum.USERNAME_EXISTED);
        }
        Account account = new Account();
        BeanUtils.copyProperties(createDto, account);
        account.setRole(Role.USER);
        // Mã hoá mật khẩu rồi lưu vào DB
        String passwordEncoder = new BCryptPasswordEncoder().encode(createDto.getPassword());
        account.setPassword(passwordEncoder);
        return accountRepository.save(account);
    }
    @PostMapping("/login-v2")
    public AccountLoginResponse loginV2(@RequestParam String username, @RequestParam String password){
        Optional<Account> accountOptional = accountRepository.findByUsername(username);
        if (accountOptional.isEmpty()){
            throw new CustomException(ErrorResponseEnum.LOGIN_USERNAME_NOT_EXISTED);
        }
        Account account = accountOptional.get();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean checkPassword = passwordEncoder.matches(password, account.getPassword());
        if (!checkPassword){
            throw new CustomException(ErrorResponseEnum.LOGIN_PASSWORD_FALSE);
        }
        AccountLoginResponse response = new AccountLoginResponse();
        BeanUtils.copyProperties(account, response);
        return response;
    }

    @PostMapping("/login-jwt")
    public AccountLoginResponse loginJWT(@RequestParam String username,@RequestParam String password){
        // Bước1: Kiểm tra username
        Optional<Account> accountOptional = accountRepository.findByUsername(username);
        if (accountOptional.isEmpty()){
            throw new CustomException(ErrorResponseEnum.LOGIN_USERNAME_NOT_EXISTED);
        }
        Account account = accountOptional.get();

        // Bước 2: Kiểm tra password
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean checkPassword = passwordEncoder.matches(password, account.getPassword());
        if (!checkPassword){
            throw new CustomException(ErrorResponseEnum.LOGIN_PASSWORD_FALSE);
        }
        AccountLoginResponse response = new AccountLoginResponse();
        BeanUtils.copyProperties(account, response);

        // Bước3: Tạo ra token
        String token = jwtTokenUtils.createAccessToken(response);
        // Bước 4: set token vào AccountLoginResponse -> return
        response.setToken(token);
        return response;
    }
}
