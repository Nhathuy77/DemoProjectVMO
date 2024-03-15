package com.example.demoprojectmysql.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
        @GetMapping("/login")
        public String login() {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String username = auth.getName();
            return "bạn đã đăng nhập thành công!"+ username;
        }
}
