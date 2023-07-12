package com.ivoyant.customerjourney.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Orders {
    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("orderDate")
    private String orderDate;

    @JsonProperty("orderStepStatus")
    private String orderStepStatus;
}