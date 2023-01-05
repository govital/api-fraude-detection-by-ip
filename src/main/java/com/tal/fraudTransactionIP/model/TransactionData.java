package com.tal.fraudTransactionIP.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "id","userId","name","amount","ip" })
public class TransactionData {
    private String id;
    private String userId;
    private String name;
    private int amount;
    private String ip;
    private String hostname;
    private String type;
    private String continent_code;
    private String continent_name;
    private String country_code;
    private String country_name;
    private String region_code;
    private String region_name;
    private String city;
    private String zip;
    private double latitude;
    private double longitude;
    private LocationData location;
    private TimeZoneData time_zone;
    private CurrencyData currency;
    private ConnectionData connection;
    private SecurityData security;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContinent_code() {
        return continent_code;
    }

    public void setContinent_code(String continent_code) {
        this.continent_code = continent_code;
    }

    public String getContinent_name() {
        return continent_name;
    }

    public void setContinent_name(String continent_name) {
        this.continent_name = continent_name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getRegion_code() {
        return region_code;
    }

    public void setRegion_code(String region_code) {
        this.region_code = region_code;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLocation() {
        if(location == null) {
            return "null";
        }
        return location.toString();
    }

    public void setLocation(LocationData location) {
        this.location = location;
    }

    public String getTime_zone() {
        if(time_zone == null) {
            return "null";
        }
        return time_zone.toString();
    }

    public void setTime_zone(TimeZoneData time_zone) {
        this.time_zone = time_zone;
    }

    public String getCurrency() {
        if(currency == null) {
            return "null";
        }
        return currency.toString();
    }

    public void setCurrency(CurrencyData currency) {
        this.currency = currency;
    }

    public String getConnection() {
        if(connection == null) {
            return "null";
        }
        return connection.toString();
    }

    public void setConnection(ConnectionData connection) {
        this.connection = connection;
    }

    public String getSecurity() {
        if(security == null) {
            return "null";
        }
        return security.toString();
    }

    public void setSecurity(SecurityData security) {
        this.security = security;
    }
}
