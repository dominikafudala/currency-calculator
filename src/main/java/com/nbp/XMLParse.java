package com.nbp;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParse {
    private Document data;

    public XMLParse() {
        this.data = new RemoteProvider().getData();
    }

    public Currencies createCurrencies() throws Exception {
        if (data == null) {
            throw new Exception("Data is null");
        }
        // get all <pozycja>
        NodeList entries = data.getElementsByTagName("pozycja");
        if(entries.getLength() == 0){
            throw new Exception("No tag <pozycja>, can't create Currencies");
        }

        Currencies currenciesList = Currencies.getInstance();
        currenciesList.addCurrency("polski zloty", 1, "PLN", 1);

        for(int i = 0; i < entries.getLength(); i++){
            Node entry = entries.item(i);
            Element element = (Element) entry;
            try{
                String currencyName = element.getElementsByTagName("nazwa_waluty").item(0).getTextContent();
                int currencyConverter = Integer.parseInt(element.getElementsByTagName("przelicznik").item(0).getTextContent());
                String currencyCode = element.getElementsByTagName("kod_waluty").item(0).getTextContent();
                double currencyRate = Double.parseDouble(element.getElementsByTagName("kurs_sredni").item(0).getTextContent().replace(",", "."));

                currenciesList.addCurrency(currencyName, currencyConverter, currencyCode, currencyRate);
            }catch(NullPointerException e){
                System.out.println("Dodawanie waluty nie powiodło się");
            }
        }
        return currenciesList;
    }
}
