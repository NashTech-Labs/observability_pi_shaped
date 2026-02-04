package com.nashtech.observability_pi_shaped.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;

    private double price;

    private String status;

    private LocalDateTime createdAt;

    public Order(String itemName, double price, String status) {
        this.itemName = itemName;
        this.price = price;
        this.status = status;
        this.createdAt = LocalDateTime.now();
    }
}
