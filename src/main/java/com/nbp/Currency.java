package com.nbp;

public class Currency {
    private String currencyName;
    private int currencyConverter;
    private String currencyCode;
    private double currencyRate;

    public Currency(String currencyName, int currencyConverter, String currencyCode, double currencyRate) {
        this.currencyName = currencyName;
        this.currencyConverter = currencyConverter;
        this.currencyCode = currencyCode;
        this.currencyRate = currencyRate;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public int getCurrencyConverter() {
        return currencyConverter;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public double getCurrencyRate() {
        return currencyRate;
    }
}
