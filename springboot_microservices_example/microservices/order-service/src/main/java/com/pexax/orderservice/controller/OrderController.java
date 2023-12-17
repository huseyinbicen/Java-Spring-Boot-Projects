package com.pexax.orderservice.controller;

import com.pexax.orderservice.dto.request.OrderRequest;
import com.pexax.orderservice.service.OrderCommandService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderCommandService orderCommandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "order-service-inventory", fallbackMethod = "placeOrderFallbackMethod")
    @TimeLimiter(name = "order-service-inventory")
    @Retry(name = "order-service-inventory")
    public CompletableFuture<String> placeOrder(@RequestBody OrderRequest orderRequest){
        return CompletableFuture.supplyAsync(() -> orderCommandService.placeOrder(orderRequest));
    }

    public CompletableFuture<String> placeOrderFallbackMethod(OrderRequest orderRequest, RuntimeException runtimeException) {
        return CompletableFuture.supplyAsync(() -> "Oops! Something went wrong, please try to order after some time!");
    }
}
