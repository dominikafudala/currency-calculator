package com.nbp;

import java.util.Scanner;

public class UserInput {
    private String code1;
    private String code2;
    private double value1;
    private static Scanner scanner = new Scanner(System.in);

    public UserInput() {
        this.code1 = "";
        this.code2 = "";
        this.value1 = 0.0;
    }

    public String getCode1() {
        do{
            System.out.println("Wprowadz kod pierwszej waluty");
            code1 = scanner.nextLine();
        }while(!this.validateCodeInput(code1));

        return code1;
    }

    public String getCode2() {
        do{
            System.out.println("Wprowadz kod drugiej waluty");
            code2 = scanner.nextLine();
        }while(!this.validateCodeInput(code2));
        return code2;
    }

    public double getValue1() {
        while(true){
            System.out.println("Wprowadz ilosc pierwszej waluty");
            try{
                value1 = Double.parseDouble(scanner.nextLine());
                break;
            }
            catch(NumberFormatException e){
                System.out.println("Wprowadzono liczbe w zlym formacie. Sprobuj ponownie");
            }
        }
        return value1;
    }

    private boolean validateCodeInput(String code){
        if(!code.matches("^.{3}$")){
            System.out.println("Kod powinien byc 3 literowy, sprobuj jeszcze raz");
            return false;
        }
        return true;
    }
}
