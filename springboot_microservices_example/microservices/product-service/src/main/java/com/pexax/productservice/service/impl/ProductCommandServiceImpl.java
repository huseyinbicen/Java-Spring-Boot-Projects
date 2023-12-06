package com.pexax.productservice.service.impl;

import com.pexax.productservice.dto.request.ProductRequest;
import com.pexax.productservice.model.Product;
import com.pexax.productservice.repository.ProductRepository;
import com.pexax.productservice.service.ProductCommandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProductCommandServiceImpl implements ProductCommandService {

    private  final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        try {
            Product product = Product.builder()
                    .name(productRequest.getName())
                    .description(productRequest.getDescription())
                    .price(productRequest.getPrice())
                    .build();

            productRepository.save(product);
            log.info("Product {} is saved", product.getId());
        } catch (Exception e) {
            log.error("Product cannot save, Error message is: {}", e.getMessage());
        }
    }
}
