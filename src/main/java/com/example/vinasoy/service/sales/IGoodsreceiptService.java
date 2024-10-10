package com.example.vinasoy.service.sales;

import com.example.vinasoy.dto.sales.GoodsissueDTO;
import com.example.vinasoy.dto.sales.GoodsreceiptDTO;

import java.util.List;

public interface IGoodsreceiptService {
    List<GoodsreceiptDTO> findAllGoodsreceipt();
    GoodsreceiptDTO addGoodsreceipt(GoodsreceiptDTO goodsreceiptDTO);
    GoodsreceiptDTO updateGoodsreceipt(String goodsissueId, GoodsreceiptDTO goodsreceiptDTO);
    void deleteGoodsreceipt(String goodsReceiptId);
    GoodsreceiptDTO findGoodsreceiptById(String goodsReceiptId);
}
