package com.nbp;

import java.util.Scanner;

public class NBP {
    public static void main(String[] args){
        try{
            new XMLParse().createCurrencies();
            Scanner scanner = new Scanner(System.in);
            String choice = "";
            while(true){
                System.out.println("\n[s] - zacznij konwertowanie waluty");
                System.out.println("[q] - zakoncz program");
                choice = scanner.nextLine();
                switch(choice) {
                    case "s": System.out.println("Przeliczono. Otrzymasz " + String.format("%.2f", new Converter().getResult()) + " docelowej waluty");
                    break;
                    case "q": return;
                    default:
                        System.out.println("Niepoprawna opcja");
                }
                }
            }
        catch(Exception e){
            System.out.println("Konczenie programu");
            e.printStackTrace();
        }
    }
}
