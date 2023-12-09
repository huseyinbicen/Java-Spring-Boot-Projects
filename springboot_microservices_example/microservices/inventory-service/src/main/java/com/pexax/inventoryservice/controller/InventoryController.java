package com.pexax.inventoryservice.controller;

import com.pexax.inventoryservice.dto.response.InventoryResponse;
import com.pexax.inventoryservice.service.InventoryQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryQueryService inventoryQueryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCodes) {
        return inventoryQueryService.isInStocks(skuCodes);
    }
}
