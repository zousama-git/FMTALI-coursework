package com.cars;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;


public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Collection<Car> cars = new ArrayList<>();

        int menuOption = 0;

        do {
            System.out.println("Goodday, welcome to the application ");
            System.out.print("""
                        MENU
                           (1) Capture Vehicle details 
                           (2) View vehicles report 
                           (3) Exit app

                    Enter option:  """);

            menuOption = input.nextInt();

            if (menuOption == 1){
                Car carObj = new Car();
                
                int year, millage;
                String make, model, plateNumber = "", vinNumber;

                System.out.print("Enter Make: ");
                make = input.next();
                carObj.setMake(make);

                System.out.print("Enter Model: ");
                model = input.next();
                carObj.setModel(model);

                System.out.print("Enter Vin Number: ");
                vinNumber = input.next();
                while(vinNumber.length() != 17 ){
                    System.out.print("Enter a valid Vin Number of 17 charaters: ");
                    vinNumber = input.next();
                }
                carObj.setVin(vinNumber);
                

                System.out.print("""
                    Choose number plate format:
                        1) Old formart (e.g ABC123GP)
                        2) New formart (e.g AB12CDGP)
                    Enter option:  """);
                int plateNumChoice = input.nextInt();

                if(plateNumChoice == 1){
                    System.out.print("Enter plate number (e.g ABC123GP): ");
                    plateNumber =  input.next();
                }
                else {
                    System.out.print("Enter plate number (e.g AB12CDGP): ");
                    plateNumber = input.next();
                }
                carObj.setPlateNumber(plateNumber);

                System.out.print("Enter Millage: ");
                millage = input.nextInt();
                carObj.setMillage(millage);

                System.out.print("Enter Year: ");
                year = input.nextInt();
                carObj.setYear(year);

                cars.add(carObj);
            } else if(menuOption == 2){
                if(cars.isEmpty()){
                    System.out.println("There are no cars captured");
                } else{
                    System.out.println("""
                        *****************************************
                        VEHICLE REPORT
                        *****************************************
                    """);
                    for (Car carObject : cars){
                        System.out.println("Make: " + carObject.getMake());
                        System.out.println("Model: " + carObject.getModel());
                        System.out.println("Plate Number: " + carObject.getPlateNumber());
                        System.out.println("Vin Number: " + carObject.getVin());
                        System.out.println("Year: " + carObject.getYear());
                        System.out.println("Millage: " + carObject.getMillage());
                    }

                    System.out.println("""
                           (1) Capture Vehicle details 
                           (3) Exit app
                            """);
                    menuOption = input.nextInt();
                }
            } 
            else if(menuOption == 3) System.out.println("Thanks for using the application");
            else System.out.println("Enter Valid Option");
            
        } while(menuOption != 3);
    }
}