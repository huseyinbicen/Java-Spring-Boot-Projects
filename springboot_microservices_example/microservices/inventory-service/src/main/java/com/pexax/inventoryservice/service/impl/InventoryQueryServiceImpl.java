package com.pexax.inventoryservice.service.impl;

import com.pexax.inventoryservice.repository.InventoryRepository;
import com.pexax.inventoryservice.service.InventoryQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InventoryQueryServiceImpl implements InventoryQueryService {

    private final InventoryRepository inventoryRepository;
    @Override
    public boolean isInStock(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}
