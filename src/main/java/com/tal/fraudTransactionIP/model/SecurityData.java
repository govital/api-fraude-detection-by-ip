package com.tal.fraudTransactionIP.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SecurityData {
    private Boolean is_proxy;
    private String proxy_type;
    private Boolean is_crawler;
    private String crawler_name;
    private String crawler_type;
    private Boolean is_tor;
    private String threat_level;
    private List<String> threat_types;

    public Boolean getIs_proxy() {
        return is_proxy;
    }

    public void setIs_proxy(Boolean is_proxy) {
        this.is_proxy = is_proxy;
    }

    public String getProxy_type() {
        return proxy_type;
    }

    public void setProxy_type(String proxy_type) {
        this.proxy_type = proxy_type;
    }

    public Boolean getIs_crawler() {
        return is_crawler;
    }

    public void setIs_crawler(Boolean is_crawler) {
        this.is_crawler = is_crawler;
    }

    public String getCrawler_name() {
        return crawler_name;
    }

    public void setCrawler_name(String crawler_name) {
        this.crawler_name = crawler_name;
    }

    public String getCrawler_type() {
        return crawler_type;
    }

    public void setCrawler_type(String crawler_type) {
        this.crawler_type = crawler_type;
    }

    public Boolean getIs_tor() {
        return is_tor;
    }

    public void setIs_tor(Boolean is_tor) {
        this.is_tor = is_tor;
    }

    public String getThreat_level() {
        return threat_level;
    }

    public void setThreat_level(String threat_level) {
        this.threat_level = threat_level;
    }

    public List<String> getThreat_types() {
        return threat_types;
    }

    public void setThreat_types(List<String> threat_types) {
        this.threat_types = threat_types;
    }

    @Override
    public String toString() {
        return "SecurityData{" +
                "is_proxy=" + is_proxy +
                ", proxy_type='" + proxy_type + '\'' +
                ", is_crawler=" + is_crawler +
                ", crawler_name='" + crawler_name + '\'' +
                ", crawler_type='" + crawler_type + '\'' +
                ", is_tor=" + is_tor +
                ", threat_level='" + threat_level + '\'' +
                ", threat_types=" + threat_types +
                '}';
    }
}
