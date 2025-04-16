package com.ecom.dto;

import lombok.Data;

@Data
public class CartItemDTO {
    Long cartItemId;
    Long productId;
    String productName;
    Integer quantity;
    Double subtotal;
}
