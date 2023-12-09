package com.pexax.orderservice.service.impl;

import com.pexax.orderservice.dto.OrderLineItemDTO;
import com.pexax.orderservice.dto.request.OrderRequest;
import com.pexax.orderservice.dto.response.InventoryResponse;
import com.pexax.orderservice.model.Order;
import com.pexax.orderservice.model.OrderLineItem;
import com.pexax.orderservice.repository.OrderRepository;
import com.pexax.orderservice.service.OrderCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.MissingRequestValueException;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderCommandServiceImpl implements OrderCommandService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;
    @Override
    public void placeOrder(OrderRequest request) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItem> orderLineItems = request.getOrderLineItemDTOS()
                .stream()
                .map(this::mapToDTO)
                .toList();

        order.setOrderLineItems(orderLineItems);

        List<String> skuCodes = order.getOrderLineItems().stream().map(OrderLineItem::getSkuCode).toList();

        InventoryResponse[] inventoryResponses = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCodes", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProductInStock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);

        if (allProductInStock) {
            orderRepository.save(order);
        } else {
            throw new ErrorResponseException(HttpStatus.NOT_FOUND);
        }
    }

    private OrderLineItem mapToDTO(OrderLineItemDTO dto) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setPrice(dto.getPrice());
        orderLineItem.setSkuCode(dto.getSkuCode());
        orderLineItem.setQuantity(dto.getQuantity());
        return orderLineItem;
    }
}
