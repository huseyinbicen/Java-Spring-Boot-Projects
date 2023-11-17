package com.pexax.productservice.service;

import com.pexax.productservice.dto.request.ProductRequest;
import com.pexax.productservice.model.Product;
import com.pexax.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductCommandService {

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
