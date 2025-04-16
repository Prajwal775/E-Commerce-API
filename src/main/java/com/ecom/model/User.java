package com.ecom.model;


import com.ecom.Enumeration.RoleType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID userId;
    String username;
    String password;
    @Enumerated(EnumType.STRING)
    RoleType role;

    // One user can have many carts.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Cart> cartList = new ArrayList<>();

    // One user can have many orders.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orderList = new ArrayList<>();

}
