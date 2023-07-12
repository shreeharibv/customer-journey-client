package com.ivoyant.customerjourney.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Events {
    @JsonProperty("type")
    private String type;

    @JsonProperty("seqNo")
    private String seqNo;

    @JsonProperty("actvCode")
    private String actvCode;

    @JsonProperty("actvRsnCode")
    private String actvRsnCode;

    @JsonProperty("description")
    private String description;

    @JsonProperty("date")
    private String date;

    @JsonProperty("timestamp")
    private Timestamp timestamp;

    @JsonProperty("attId")
    private String attId;

    @JsonProperty("ptn")
    private String ptn;

    @JsonProperty("applicationId")
    private String applicationId;
}