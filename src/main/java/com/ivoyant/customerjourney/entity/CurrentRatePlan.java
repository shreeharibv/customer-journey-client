package com.ivoyant.customerjourney.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrentRatePlan {
    @JsonProperty("soc")
    private String soc;

    @JsonProperty("timeElapsed")
    private int timeElapsed;

    @JsonProperty("longDescription")
    private String longDescription;

    @JsonProperty("shortDescription")
    private String shortDescription;

    @JsonProperty("rate")
    private double rate;

    @JsonProperty("effectiveDate")
    private String effectiveDate;

    @JsonProperty("isGrandfatheredPlan")
    private boolean isGrandfatheredPlan;
}