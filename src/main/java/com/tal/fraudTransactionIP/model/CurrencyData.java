package com.tal.fraudTransactionIP.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyData {
    private String code;
    private String name;
    private String plural;
    private String symbol;
    private String symbol_native;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlural() {
        return plural;
    }

    public void setPlural(String plural) {
        this.plural = plural;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol_native() {
        return symbol_native;
    }

    public void setSymbol_native(String symbol_native) {
        this.symbol_native = symbol_native;
    }

    @Override
    public String toString() {
        return "CurrencyData{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", plural='" + plural + '\'' +
                ", symbol='" + symbol + '\'' +
                ", symbol_native='" + symbol_native + '\'' +
                '}';
    }
}
