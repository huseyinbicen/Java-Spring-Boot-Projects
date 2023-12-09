package com.pexax.inventoryservice.service.impl;

import com.pexax.inventoryservice.dto.response.InventoryResponse;
import com.pexax.inventoryservice.repository.InventoryRepository;
import com.pexax.inventoryservice.service.InventoryQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InventoryQueryServiceImpl implements InventoryQueryService {

    private final InventoryRepository inventoryRepository;
    @Override
    public List<InventoryResponse> isInStocks(List<String> skuCodes) {
        return inventoryRepository.findBySkuCodeIn(skuCodes)
                .stream()
                .map(x -> InventoryResponse.builder()
                        .skuCode(x.getSkuCode())
                        .isInStock(x.getQuantity() > 0)
                        .build())
                .toList();
    }
}
