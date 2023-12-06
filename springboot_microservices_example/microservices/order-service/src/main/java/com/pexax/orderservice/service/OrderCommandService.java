package com.pexax.orderservice.service;

import com.pexax.orderservice.dto.request.OrderRequest;

public interface OrderCommandService {

    void placeOrder (OrderRequest request);
}
