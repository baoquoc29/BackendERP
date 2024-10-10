package com.example.vinasoy.controller.sales;

import com.example.vinasoy.dto.sales.ApiResponse;
import com.example.vinasoy.dto.sales.GoodsissueDTO;
import com.example.vinasoy.dto.sales.GoodsreceiptDTO;
import com.example.vinasoy.service.sales.implement.GoodsissueService;
import com.example.vinasoy.service.sales.implement.GoodsreceiptService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/goodsreceipt")
public class GoodsreceiptController {
    private final GoodsreceiptService goodsreceiptService;

    @GetMapping
    public ResponseEntity<?> findAllGoodReceipt() {
        List<GoodsreceiptDTO> goodsreceipt = goodsreceiptService.findAllGoodsreceipt();
        ApiResponse<List<GoodsreceiptDTO>> apiResponse = new ApiResponse<>();
        apiResponse.setData(goodsreceipt);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findGoodsReceiptById(@PathVariable("id") String id) {
        GoodsreceiptDTO goodsreceipt = goodsreceiptService.findGoodsreceiptById(id.toUpperCase());
        ApiResponse<GoodsreceiptDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(goodsreceipt);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PostMapping
    public ResponseEntity<?> addGoodsRecepit(@RequestBody @Valid GoodsreceiptDTO goodsreceiptDTO) {
        GoodsreceiptDTO goodsreceipt = goodsreceiptService.addGoodsreceipt(goodsreceiptDTO);
        ApiResponse<GoodsreceiptDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(goodsreceipt);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGoodsReceipt(@PathVariable("id") String id,
                                             @RequestBody @Valid GoodsreceiptDTO goodsreceiptDTO) {
        GoodsreceiptDTO goodsreceipt = goodsreceiptService.updateGoodsreceipt(id.toUpperCase(), goodsreceiptDTO);
        ApiResponse<GoodsreceiptDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(goodsreceipt);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGoodsissue(@PathVariable("id") String id) {
        goodsreceiptService.deleteGoodsreceipt(id.toUpperCase());
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setData("Xoa thanh cong");
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }
}
