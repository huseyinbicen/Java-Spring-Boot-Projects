package com.pexax.inventoryservice.service.impl;

import com.pexax.inventoryservice.dto.response.InventoryResponse;
import com.pexax.inventoryservice.repository.InventoryRepository;
import com.pexax.inventoryservice.service.InventoryQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class InventoryQueryServiceImpl implements InventoryQueryService {

    private final InventoryRepository inventoryRepository;
    @Override
    public List<InventoryResponse> isInStocks(List<String> skuCodes) {
//        try {
//            testTimeout();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return inventoryRepository.findBySkuCodeIn(skuCodes)
                .stream()
                .map(x -> InventoryResponse.builder()
                        .skuCode(x.getSkuCode())
                        .isInStock(x.getQuantity() > 0)
                        .build())
                .toList();
    }

    private static void testTimeout() throws InterruptedException {
        log.info("Wait started");
        Thread.sleep(10000);
        log.info("Wait ended");
    }
}
