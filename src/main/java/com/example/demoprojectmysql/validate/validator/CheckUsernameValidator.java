package com.example.demoprojectmysql.validate.validator;


import com.example.demoprojectmysql.repository.AccountRepository;
import com.example.demoprojectmysql.validate.annotation.CheckUsername;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckUsernameValidator implements ConstraintValidator<CheckUsername, String> {
// Khai báo repository:
    @Autowired
AccountRepository accountRepository;
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        // Kiểm tra giá trị username có tồn tại trong DB hay ko?
        // Nếu usernmae có tồn tại -> kq = true -> không hợp lệ -> isValid = false;
        return !accountRepository.existsByUsername(username);
    }
}
