package com.ivoyant.customerjourney.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Subscribers {
    @JsonProperty("subscriberId")
    private String subscriberId;
    @JsonProperty("subscriberDetails")
    private SubscriberDetails subscriberDetails;
    @JsonProperty("services")
    private Services services;
}
