package com.pexax.inventoryservice.service;

import com.pexax.inventoryservice.dto.response.InventoryResponse;

import java.util.List;

public interface InventoryQueryService {

    List<InventoryResponse> isInStocks(List<String> skuCodes);
}
