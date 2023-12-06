package com.pexax.inventoryservice.controller;

import com.pexax.inventoryservice.service.InventoryQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryQueryService inventoryQueryService;

    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("sku-code") String skuCode) {
        return inventoryQueryService.isInStock(skuCode);
    }
}
