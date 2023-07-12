package com.ivoyant.customerjourney.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddOns {
    @JsonProperty(value = "currentAddOnsList")
    private List<CurrentAddOns> currentAddOnsList;
    @JsonProperty(value = "previousAddOnsList")
    private List<PreviousAddOns> previousAddOnsList;

}
