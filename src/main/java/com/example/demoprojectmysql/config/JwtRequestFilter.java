package com.example.demoprojectmysql.config;

import com.example.demoprojectmysql.utils.JWTTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;


@Component
public class JwtRequestFilter  {
    private static final String AUTHORIZATION = "Authorization";

    @Autowired
    private JWTTokenUtils jwtTokenUtils;

}
