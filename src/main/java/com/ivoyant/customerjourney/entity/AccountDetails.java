package com.ivoyant.customerjourney.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDetails {
    @JsonProperty(value = "banStatus")
    private String banStatus;
    @JsonProperty(value = "accountType")
    private String accountType;
    @JsonProperty(value = "accountSubType")
    private String accountSubType;
    @JsonProperty(value = "statusActvCode")
    private String statusActvCode;
    @JsonProperty(value = "statusActvRsnCode")
    private String statusActvRsnCode;
    @JsonProperty(value = "statusDate")
    private String statusDate;
    @JsonProperty(value = "customerSince")
    private String customerSince;
    @JsonProperty(value = "billCycle")
    private int billCycle;
    @JsonProperty(value = "billCycleDate")
    private String billCycleDate;
    @JsonProperty(value = "billDueDate")
    private String billDueDate;
    @JsonProperty(value = "emailAddress")
    private String emailAddress;
    @JsonProperty(value = "preferredLanguage")
    private String preferredLanguage;
    @JsonProperty(value = "arBalance")
    private float arBalance;
    @JsonProperty(value = "openCases")
    private int openCases;
}