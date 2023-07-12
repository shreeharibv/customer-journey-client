package com.ivoyant.customerjourney.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Customer {
    @JsonProperty("billingAccountNumber")
    private String billingAccountNumber;

    @JsonProperty("accountDetails")
    private AccountDetails accountDetails;

    @JsonProperty("billingAddress")
    private BillingAddress billingAddress;

    @JsonProperty("name")
    private Name name;

    @JsonProperty("subscribersList")
    private List<Subscribers> subscribersList;

    @JsonProperty("promotions")
    private Promotions promotions;

    @JsonProperty("eventsList")
    private List<Events> eventsList;

    @JsonProperty("ordersList")
    private List<Orders> ordersList;

    @JsonProperty("interactionSummary")
    private InteractionSummary interactionSummary;
}
