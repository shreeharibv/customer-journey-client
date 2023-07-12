package com.ivoyant.customerjourney.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrentDevice {
    @JsonProperty(value = "imei")
    private String imei;
    @JsonProperty(value = "imsi")
    private String imsi;
    @JsonProperty(value = "sim")
    private String sim;
    @JsonProperty(value = "sku")
    private String sku;
    @JsonProperty(value = "model")
    private String model;
    @JsonProperty(value = "os")
    private String os;
    @JsonProperty(value = "deviceType")
    private String deviceType;
    @JsonProperty(value = "network")
    private String network;
    @JsonProperty(value = "simType")
    private String simType;
    @JsonProperty(value = "eSimCompatibleDevice")
    private Boolean eSimCompatibleDevice;
    @JsonProperty(value = "eSimProfileType")
    private String eSimProfileType;
    @JsonProperty(value = "eSimOnly")
    private Boolean eSimOnly;
}
