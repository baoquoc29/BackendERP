package com.example.vinasoy.controller.sales;

import com.example.vinasoy.dto.sales.ApiResponse;
import com.example.vinasoy.dto.sales.CustomerDTO;
import com.example.vinasoy.dto.sales.GoodsissueDTO;
import com.example.vinasoy.service.sales.implement.CustomerService;
import com.example.vinasoy.service.sales.implement.GoodsissueService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/goodsissue")
public class GoodsissueController {
    private final GoodsissueService goodsissueService;

    @GetMapping
    public ResponseEntity<?> findAllGoodsissue() {
        List<GoodsissueDTO> goodsissues = goodsissueService.findAllGoodsissue();
        ApiResponse<List<GoodsissueDTO>> apiResponse = new ApiResponse<>();
        apiResponse.setData(goodsissues);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findGoodsissueById(@PathVariable("id") String id) {
        GoodsissueDTO goodsissue = goodsissueService.findGoodsissueById(id.toUpperCase());
        ApiResponse<GoodsissueDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(goodsissue);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PostMapping
    public ResponseEntity<?> addGoodsissue(@RequestBody @Valid GoodsissueDTO goodsissueDTO) {
        GoodsissueDTO goodsissue = goodsissueService.addGoodsissue(goodsissueDTO);
        ApiResponse<GoodsissueDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(goodsissue);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGoodsisue(@PathVariable("id") String id,
                                             @RequestBody @Valid GoodsissueDTO goodsissueDTO) {
        GoodsissueDTO goodsissue = goodsissueService.updateGoodsissue(id.toUpperCase(), goodsissueDTO);
        ApiResponse<GoodsissueDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(goodsissue);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGoodsissue(@PathVariable("id") String id) {
        goodsissueService.deleteGoodsissue(id.toUpperCase());
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setData("Xoa thanh cong");
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }
}
