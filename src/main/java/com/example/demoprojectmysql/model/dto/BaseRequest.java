package com.example.demoprojectmysql.model.dto;

import lombok.Data;

@Data
public class BaseRequest {
    protected int page;
    protected int size;
    protected String sortField;
    protected String sortType; //ASC: sắp xếp tăng dần; DESC: sắp xếp giảm dần

}
