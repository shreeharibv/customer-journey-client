package com.ivoyant.customerjourney.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceDetails {
    @JsonProperty(value = "currentDevice")
    private CurrentDevice currentDevice;
}
