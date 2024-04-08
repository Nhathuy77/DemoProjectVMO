package com.example.demoprojectmysql.config.exception;

public enum ErrorResponseEnum {
    NOT_FOUND_PRODUCT(404, "Không tìm thấy sản phẩm"),
    NOT_FOUND_ACCOUNT(404, "Không tìm thấy người dùng"),
    NOT_FOUND_ORDER(404, "Không tìm thấy odder"),
    COURSE_NAME_EXISTED(400, "Course name đã tồn tại!"),
    USERNAME_EXISTED(400, "Username đã tồn tại!"),
    LOGIN_USERNAME_NOT_EXISTED(401, "Username không tồn tại!"),
    ACCOUNT_NOT_ACTIVE(403, "Tài khoản của bạn chưa được kích hoạt. Kiểm tra mail để kích hoạt tài khoản!"),
    ERROR_TELEPHONE(400, "Telephone sai"),
    LOGIN_PASSWORD_FALSE(401, "Password sai!");

    public final int status;
    public final String message;
    ErrorResponseEnum(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
