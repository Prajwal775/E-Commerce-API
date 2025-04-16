package com.ecom.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "orderitems")

public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long orderItemId;


    Integer quantity;
    Double subtotal;

    @ManyToOne()
    @JoinColumn(name = "order_id")
    Order order;

    // Many order items can refer to one product.
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    // Automatically compute subtotal before persisting/updating.
    @PrePersist
    @PreUpdate
    public void calculateSubtotal() {
        if (product != null && quantity != null) {
            subtotal = product.getPrice().doubleValue() * quantity;
        }
    }
}