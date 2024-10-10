package com.example.vinasoy.exception;

public enum ErrorCode {
    DEPARTMENT_NAME_EXISTED(409, "Department already exists"), // Conflict
    DEPARTMENT_NOT_FOUND(404, "Department not found"), // Not Found
    POSITION_NOT_FOUND(404, "Position not found"), // Not Found
    POSITION_NAME_EXIST(409, "Position name already exists"), // Conflict
    ALLOWANCE_NOT_FOUND(404, "Allowance not found"), // Not Found
    NAME_EXISTED(409, " Already exists"),
    NOT_FOUND(404, "Not found"), // Not Found
    NOT_FOUND_ID_CONTRACT(404, "Not found contract Id"),
    NOT_FOUND_ID_SALARY(404, "Not found salary Id"); // Not Found// Not Found
    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
