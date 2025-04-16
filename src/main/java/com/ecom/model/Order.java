package com.ecom.model;


import com.ecom.Enumeration.PaymentStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long orderId;

    Double total;

    @Enumerated(EnumType.STRING)
    PaymentStatus paymentStatus;

    @Temporal(TemporalType.TIMESTAMP)
    Date orderDate;

    // Many orders belong to one user.
    @ManyToOne()
    @JoinColumn(name = "userId")
    User user;

    // One order has many order items.
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItemList = new ArrayList<>();

}
