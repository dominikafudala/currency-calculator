package com.nbp;

public class Converter {
    private double result;

    public Converter() {
        this.result = 0.0;
    }

    public double getResult() {
        UserInput userInput = new UserInput();
        String code1, code2;
        Currency currency1, currency2;

        do{
            code1 = userInput.getCode1();
            currency1 = Currencies.getInstance().getByCurrencyCode(code1);

            if(currency1 == null){
                System.out.println("Waluta o podanym kodzie nie istnieje, sprobuj jeszcze raz");
            }
        }while(currency1 == null);

        double value1 = userInput.getValue1();

        do{
            code2 = userInput.getCode2();
            currency2 = Currencies.getInstance().getByCurrencyCode(code2);

            if(currency2 == null){
                System.out.println("Waluta o podanym kodzie nie istnieje, sprobuj jeszcze raz");
            }
        }while(currency2 == null);

        result = (currency1.getCurrencyRate()*currency2.getCurrencyConverter()*value1)/(currency2.getCurrencyRate()*currency1.getCurrencyConverter());
        return result;
    }
}
