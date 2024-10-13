package com.example.vinasoy.service.sales.implement;

public enum OrderStatus {
    DELIVERED("Đã giao"),
    PROCESSING("Đang xử lý");

    private final String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
