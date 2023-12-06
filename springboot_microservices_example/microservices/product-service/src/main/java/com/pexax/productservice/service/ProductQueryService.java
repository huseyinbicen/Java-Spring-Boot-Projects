package com.pexax.productservice.service;

import com.pexax.productservice.dto.response.ProductResponse;

import java.util.List;

public interface ProductQueryService {

    List<ProductResponse> getAllProducts();
}
