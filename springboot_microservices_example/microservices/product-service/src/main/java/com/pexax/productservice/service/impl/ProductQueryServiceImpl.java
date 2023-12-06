package com.pexax.productservice.service.impl;

import com.pexax.productservice.dto.response.ProductResponse;
import com.pexax.productservice.model.Product;
import com.pexax.productservice.repository.ProductRepository;
import com.pexax.productservice.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class ProductQueryServiceImpl implements ProductQueryService {

    private  final ProductRepository productRepository;

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
