package com.nashtech.observability_pi_shaped.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderRequest {

    private String itemName;
    private double price;
}
