package com.example.vinasoy.dto.employee;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ApiResponse<T>{
    private int code;
    private String message;
    private T result;

}
