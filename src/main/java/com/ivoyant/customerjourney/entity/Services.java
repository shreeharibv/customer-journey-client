package com.ivoyant.customerjourney.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Services {
    @JsonProperty("totalRate")
    private double totalRate;

    @JsonProperty("ratePlans")
    private RatePlans ratePlans;

    @JsonProperty("addOns")
    private AddOns addOns;
}
