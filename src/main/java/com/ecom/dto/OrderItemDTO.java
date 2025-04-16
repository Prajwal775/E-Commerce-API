package com.ecom.dto;

import lombok.Data;

@Data
public class OrderItemDTO {
    Long orderItemId;
    Long productId;
    String productName;
    Integer quantity;
    Double subtotal;
}
