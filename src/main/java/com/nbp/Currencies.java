package com.nbp;

import java.util.ArrayList;
import java.util.List;

public class Currencies {
    private static Currencies instance;
    private List<Currency> currenciesList;

    private Currencies() {
        currenciesList = new ArrayList<>();
    }

    public static Currencies getInstance(){
        if(instance == null){
            instance = new Currencies();
        }

        return instance;
    }

    public Currency getByCurrencyCode(String code){
        for(Currency currency: currenciesList){
            if(currency.getCurrencyCode().equals(code.toUpperCase())){
                return currency;
            }
        }
        return null;
    }

    public Currency addCurrency(String currencyName, int currencyConverter, String currencyCode, double currencyRate){
        Currency currency = new Currency(currencyName, currencyConverter,currencyCode, currencyRate);
        currenciesList.add(currency);
        return currency;
    }
}
