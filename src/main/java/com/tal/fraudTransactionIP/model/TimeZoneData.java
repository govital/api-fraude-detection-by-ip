package com.tal.fraudTransactionIP.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeZoneData {
    private String id;
    private String current_time;
    private Integer gmt_offset;
    private String code;
    private Boolean is_daylight_saving;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(String current_time) {
        this.current_time = current_time;
    }

    public Integer getGmt_offset() {
        return gmt_offset;
    }

    public void setGmt_offset(Integer gmt_offset) {
        this.gmt_offset = gmt_offset;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getIs_daylight_saving() {
        return is_daylight_saving;
    }

    public void setIs_daylight_saving(Boolean is_daylight_saving) {
        this.is_daylight_saving = is_daylight_saving;
    }

    @Override
    public String toString() {
        return "TimeZoneData{" +
                "id='" + id + '\'' +
                ", current_time='" + current_time + '\'' +
                ", gmt_offset=" + gmt_offset +
                ", code='" + code + '\'' +
                ", is_daylight_saving=" + is_daylight_saving +
                '}';
    }
}
