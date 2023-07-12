package com.ivoyant.customerjourney.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Promotions {
    @JsonProperty("hboMaxAvod")
    private boolean hboMaxAvod;
}
