package util;

import java.util.Scanner;
import java.util.Locale;

public class Input {

    Scanner input;

    public Input() {
        this.input = new Scanner(System.in);
        this.input.useLocale(Locale.US);
    }

    String getString(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    double getValidInput(String prompt, double min, double max) {
        double value;

        while (true) {
            System.out.print(prompt);

            if (input.hasNextDouble()) {
                value = input.nextDouble();
                input.nextLine();

                if (value >= min && value <= max) {
                    return value;
                }
                System.out.printf("Please enter a value between %.0f and %.0f.%n%n", min, max);

            } else {
                System.out.println("That is not a number. Please try again.\n");
                input.nextLine();
            }
        }
    }

    int getUnitChoice() {
        int choice;

        while (true) {
            System.out.println("Select a unit system:");
            System.out.println("[1] Metric   (kg, cm)");
            System.out.println("[2] Imperial (lbs, inches)");
            System.out.print("Your choice: ");

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();

                if (choice == 1 || choice == 2) {
                    return choice;
                }
                System.out.println("Please enter 1 or 2.\n");

            } else {
                System.out.println("Please enter 1 or 2.\n");
                input.nextLine();
            }
        }
    }

    char getCharInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine();

            if (!line.isEmpty()) {
                return Character.toUpperCase(line.charAt(0));
            }
            System.out.println("Please type a character.\n");
        }
    }

    String getUsername() {
        System.out.print("Username: ");
        return input.nextLine().toLowerCase();
    }

    String getPassword() {
        System.out.print("Password: ");
        return input.nextLine();
    }

    public void close() {
        input.close();
    }
}