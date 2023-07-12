package com.ivoyant.customerjourney.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.core.util.Json;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RatePlans {
    @JsonProperty("currentRatePlanList")
    private List<CurrentRatePlan> currentRatePlanList;
}
