package com.tal.fraudTransactionIP.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConnectionData {
    private Integer asn;
    private String isp;

    public Integer getAsn() {
        return asn;
    }

    public void setAsn(Integer asn) {
        this.asn = asn;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    @Override
    public String toString() {
        return "ConnectionData{" +
                "asn=" + asn +
                ", isp='" + isp + '\'' +
                '}';
    }
}
