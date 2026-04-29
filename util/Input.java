package util;

import java.util.Scanner;
import java.util.Locale;

public class Input {

    Scanner input;

    public Input() {
        this.input = new Scanner(System.in);
        this.input.useLocale(Locale.US);
    }

    public String getString(String prompt) { //show message and wait for user input then return it as a string
        System.out.print(prompt);
        return input.nextLine();
    }

    public double getValidInput(String prompt, double min, double max) { //message to show user and range
        double value;

        while (true) {//keep running till we get a valid input
            System.out.print(prompt);

            if (input.hasNextDouble()) { //check if the input is a double
                value = input.nextDouble();
                input.nextLine(); //clear the line to prevent bugs
                if (value >= min && value <= max) break; //Checks if the number is within range and If yes >> exit loop
                else System.out.printf("Please enter a value between %.2f and %.2f.%n%n", min, max);
            } else {
                System.out.println("Invalid input. Please enter a number.\n");
                input.nextLine();
            }
        }

        return value;
    }

    public int getUnitChoice() {
        int choice;

        while (true) {
            System.out.println("Select a unit system:");
            System.out.println("	1. Metric   (kg, m)");
            System.out.println("	2. Imperial (lbs, in)");
            System.out.print("Please select either option 1 or option 2: ");

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();
                if (choice == 1 || choice == 2) break;
                else System.out.println("Invalid choice. Please enter either 1 or 2.\n");
            } else {
                System.out.println("Invalid choice. Please enter either 1 or 2.\n");
                input.nextLine();
            }
        }

        return choice;
    }

    public char getCharInput(String prompt) {
        System.out.print(prompt);
        char option = Character.toUpperCase(input.next().charAt(0)); //just to get the char but as an uppercase
        input.nextLine();
        return option;
    }

    public void close() {
        input.close();
    }
}