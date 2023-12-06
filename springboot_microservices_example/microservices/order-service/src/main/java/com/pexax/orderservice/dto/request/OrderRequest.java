package com.pexax.orderservice.dto.request;

import com.pexax.orderservice.dto.OrderLineItemDTO;
import com.pexax.orderservice.model.OrderLineItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private List<OrderLineItemDTO> orderLineItemDTOS;
}
