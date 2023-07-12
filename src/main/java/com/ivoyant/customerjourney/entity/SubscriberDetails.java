package com.ivoyant.customerjourney.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.elasticsearch.common.recycler.Recycler;

@Getter
@Setter
public class SubscriberDetails {
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("status")
    private String status;

    @JsonProperty("statusReasonCode")
    private String statusReasonCode;

    @JsonProperty("statusDate")
    private String statusDate;

    @JsonProperty("subStatusLastAct")
    private String subStatusLastAct;

    @JsonProperty("statusDescription")
    private String statusDescription;

    @JsonProperty("initActivationDate")
    private String initActivationDate;

    @JsonProperty("futureActivityIndicator")
    private boolean futureActivityIndicator;

    @JsonProperty("portProtectInd")
    private String portProtectInd;

    @JsonProperty("isPortedIn")
    private Boolean isPortedIn;

    @JsonProperty("pendingPortInIndicator")
    private boolean pendingPortInIndicator;

    @JsonProperty("pricePlanChangeCount")
    private int pricePlanChangeCount;

    @JsonProperty("emailAddress")
    private String emailAddress;

    @JsonProperty("name")
    private Name name;

    @JsonProperty("deviceDetails")
    private DeviceDetails deviceDetails;
}
