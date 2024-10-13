package com.example.vinasoy.service.sales;

import com.example.vinasoy.dto.sales.GoodsissueDTO;

import java.util.List;

public interface IGoodsissueService {
    List<GoodsissueDTO> findAllGoodsissue();
    GoodsissueDTO addGoodsissue(GoodsissueDTO goodsissueDTO);
    GoodsissueDTO updateGoodsissue(String goodsissueId, GoodsissueDTO invoicegoodsissueDTOdetailsDTO);
    void deleteGoodsissue(String goodsissueId);
    GoodsissueDTO findGoodsissueById(String goodsissueId);
}
