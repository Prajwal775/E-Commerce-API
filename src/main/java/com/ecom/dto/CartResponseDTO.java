package com.ecom.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartResponseDTO {
    Long cartId;
    Double total;
    List<CartItemDTO> cartItems;
}
