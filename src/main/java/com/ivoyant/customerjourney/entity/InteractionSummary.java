package com.ivoyant.customerjourney.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

@Getter
@Setter
public class InteractionSummary {
    @JsonProperty("recentCaller")
    private boolean recentCaller;

    @JsonProperty("recentInteractionCount")
    private int recentInteractionCount;

    @JsonProperty("lastInteractionTime")
    private String lastInteractionTime;
}