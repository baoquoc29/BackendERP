package com.example.vinasoy.controller.sales;

import com.example.vinasoy.entity.sales.Customer;
import lombok.*;
import org.springframework.data.domain.Page;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PageResponse<T> implements Serializable {
    private int pageNo;
    private int pageSize;
    private int totalPage;
    private long totalElements;
    private T items;

    public PageResponse(Page<Customer> customerPage) {
    }
}
