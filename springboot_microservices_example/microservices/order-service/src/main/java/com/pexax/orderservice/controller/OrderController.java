package com.pexax.orderservice.controller;

import com.pexax.orderservice.dto.request.OrderRequest;
import com.pexax.orderservice.service.OrderCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderCommandService orderCommandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        orderCommandService.placeOrder(orderRequest);
        return "Order Placed Successfully";
    }
}
