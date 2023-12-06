package com.pexax.productservice.service;

import com.pexax.productservice.dto.request.ProductRequest;

public interface ProductCommandService {

    void createProduct(ProductRequest productRequest);
}
