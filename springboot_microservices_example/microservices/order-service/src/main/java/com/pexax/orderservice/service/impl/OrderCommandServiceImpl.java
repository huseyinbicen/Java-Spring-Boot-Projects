package com.pexax.orderservice.service.impl;

import com.pexax.orderservice.dto.OrderLineItemDTO;
import com.pexax.orderservice.dto.request.OrderRequest;
import com.pexax.orderservice.model.Order;
import com.pexax.orderservice.model.OrderLineItem;
import com.pexax.orderservice.repository.OrderRepository;
import com.pexax.orderservice.service.OrderCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderCommandServiceImpl implements OrderCommandService {

    private final OrderRepository orderRepository;
    @Override
    public void placeOrder(OrderRequest request) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItem> orderLineItems = request.getOrderLineItemDTOS()
                .stream()
                .map(this::mapToDTO)
                .toList();

        order.setOrderLineItems(orderLineItems);
        orderRepository.save(order);
    }

    private OrderLineItem mapToDTO(OrderLineItemDTO dto) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setPrice(dto.getPrice());
        orderLineItem.setSkuCode(dto.getSkuCode());
        orderLineItem.setQuantity(dto.getQuantity());
        return orderLineItem;
    }
}
