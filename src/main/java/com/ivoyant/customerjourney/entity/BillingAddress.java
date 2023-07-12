package com.ivoyant.customerjourney.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillingAddress {
    @JsonProperty("fullAddress")
    private String fullAddress;

    @JsonProperty("addressLine1")
    private String addressLine1;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("zip")
    private String zip;

    @JsonProperty("zip4")
    private String zip4;
}
