package com.example.demoprojectmysql.utils;


import com.alibaba.fastjson.JSON;
import com.example.demoprojectmysql.model.dto.AccountLoginResponse;
import com.example.demoprojectmysql.model.dto.AccountStatus;
import com.example.demoprojectmysql.model.dto.AppExceptionDto;
import com.example.demoprojectmysql.model.entity.Account;
import com.example.demoprojectmysql.model.entity.Role;
import com.example.demoprojectmysql.repository.AccountRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Slf4j
@Component // Khai báo class này là 1 bean
public class JWTTokenUtils {
    @Autowired
    private AccountRepository accountRepository;

    private static final long EXPIRATION_TIME = 864000000; // 10 days, thời hạn của token
    private static final String SECRET = "123456"; // Chữ ký bí mật
    private static final String PREFIX_TOKEN = "Bearer"; // Ký tự đầu của token
    private static final String AUTHORIZATION = "Authorization"; // Key của token trên header

    // Hàm này dùng để tạo ra token
    public String createAccessToken(AccountLoginResponse loginDto) {
        // Tạo giá trị thời hạn token ( bằng thời gian hiện tại + 10 ngày hoặc tuỳ theo )
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
        String token = Jwts.builder()
                .setId(String.valueOf(loginDto.getId())) //set giá trị Id
                .setSubject(loginDto.getUsername()) // set giá trị subject
                .setIssuedAt(new Date())
                .setIssuer("HUY")
                .setExpiration(expirationDate) // set thời hạn của token
                .signWith(SignatureAlgorithm.HS512, SECRET) // khai báo phương thức mã hóa token và chữ ký bí mật
                .claim("authorities", loginDto.getRole().name()).compact(); // thêm trường authorities để lưu giá trị phân quyền
                //.claim("user-Agent", loginDto.getUserAgent()).compact();// thêm trường user-Agent để lưu thông tin trình duyệt đang dùng
        return token;
    }

    // Hàm này dùng để giải mã hóa token
    public AccountLoginResponse parseAccessToken(String token) {
        AccountLoginResponse loginDto = new AccountLoginResponse();
        if (!token.isEmpty()) {
            try {
                token = token.replace(PREFIX_TOKEN, "").trim();
                Claims claims = Jwts.parser() // Đối tượng giải mã token
                        .setSigningKey(SECRET)
                        .parseClaimsJws(token).getBody();
                // Lấy ra các thông tin
                String user = claims.getSubject();
                Role role = Role.valueOf(claims.get("authorities").toString());
                String id = claims.getId();
//                String userAgent = claims.get("user-Agent").toString();
                // Gán các thông tin vào đối tượng LoginDto, có thể sử dụng constructor
                loginDto.setUsername(user);
                loginDto.setRole(role);
                loginDto.setId(Integer.parseInt(id));
//                loginDto.setUserAgent(userAgent);
            } catch (Exception e) {
                log.error(e.getMessage());
                return null;
            }
        }
        return loginDto;
    }


    public AccountLoginResponse checkToken(String token, HttpServletResponse response, HttpServletRequest httpServletRequest) {
        AccountLoginResponse loginDto = null;
        try {
            if (StringUtils.isBlank(token) || !token.startsWith(PREFIX_TOKEN)) { // token bị trống -> lỗi
                responseJson(response, new AppExceptionDto("Token ko hợp lệ", 401, httpServletRequest.getRequestURI()));
                return null;
            }
            token = token.replace(PREFIX_TOKEN, "").trim();
            loginDto = parseAccessToken(token);
            if (loginDto == null) { // Ko có token trên hệ thống
                responseJson(response, new AppExceptionDto("Token ko tồn tại hoặc hết hạn",401, httpServletRequest.getRequestURI()));
                return null;
            }
            Account account = accountRepository.findByUsername(loginDto.getUsername()).get();
            if (account.getAccountStatus() != AccountStatus.ACTIVE){
                responseJson(response, new AppExceptionDto("Taig khoản bị khoá, liên hệ quản trị viên!",403, httpServletRequest.getRequestURI()));
            }
        } catch (Exception e) {
            responseJson(response, new AppExceptionDto(e.getMessage(),401, httpServletRequest.getRequestURI()));
            return null;
        }
        return loginDto;
    }


    // Hàm này dùng để response dữ liệu khi gặp lỗi
    private void responseJson(HttpServletResponse response, AppExceptionDto appException){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(appException.getStatus());
        try {
            response.getWriter().print(JSON.toJSONString(appException));
        } catch (IOException e) {
            log.debug(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

