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
@Table(name = "cartItems")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long cartItemId;

    Integer quantity;

    // Instead of storing subtotal, we calculate it on the fly.
    @Transient
    public Double getSubtotal() {
        if (product != null && quantity != null) {
            // Assumes product price is non-null.
            return product.getPrice().doubleValue() * quantity;
        }
        return 0.0;
    }

    // Many carts can belong to one user.
    @ManyToOne()
    @JoinColumn(name = "cart_id")
    Cart cart;

    // Many cart items can refer to one product.
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
