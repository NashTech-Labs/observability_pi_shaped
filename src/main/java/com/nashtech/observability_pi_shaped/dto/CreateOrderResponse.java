package com.nashtech.observability_pi_shaped.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateOrderResponse {

    private Long orderId;
    private String status;
}
