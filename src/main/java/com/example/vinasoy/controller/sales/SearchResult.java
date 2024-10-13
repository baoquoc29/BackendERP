package com.example.vinasoy.controller.sales;

import lombok.*;

import java.util.List;

@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchResult<T> {
    private PageResponse<T> pageResponse;
    private List<String> suggestions;
}