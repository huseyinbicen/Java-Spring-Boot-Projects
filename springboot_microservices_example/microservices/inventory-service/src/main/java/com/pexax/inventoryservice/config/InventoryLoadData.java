package com.pexax.inventoryservice.config;

import com.pexax.inventoryservice.model.Inventory;
import com.pexax.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryLoadData {

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory inventory1 = new Inventory();
            inventory1.setSkuCode("iphone_13_pro_max");
            inventory1.setQuantity(100);

            Inventory inventory2 = new Inventory();
            inventory2.setSkuCode("iphone_13_pro_max_red");
            inventory2.setQuantity(0);

            inventoryRepository.save(inventory1);
            inventoryRepository.save(inventory2);
        };
    }
}

