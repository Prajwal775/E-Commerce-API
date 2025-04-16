package com.ecom.dto;

import com.ecom.Enumeration.PaymentStatus;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponseDTO {
    Long orderId;
    Double total;
    PaymentStatus paymentStatus;
    List<OrderItemDTO> orderItems;
}

