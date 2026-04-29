import util.Input;
import util.BMICalculator;

public class Main {

    public static void main(String[] args) {

        Input handler = new Input();
		
        System.out.println("Metric units will be used by default. You can switch to imperial at any time.");
		
		String name = handler.getString("Enter your name: ");
        int age = (int) handler.getValidInput("Enter your age: ", 1, 120);
        double height = handler.getValidInput("Enter your height (cm): ", 50, 250) / 100; // in meters
        double weight = handler.getValidInput("Enter your weight (kg): ", 10, 600);

        BMICalculator bmi = new BMICalculator(name, age, weight, height);

        char repeat;

        do {
            int unitChoice = handler.getUnitChoice();

            bmi.setUnitChoice(unitChoice);
            bmi.displayInfo();

            repeat = handler.getCharInput("Do you want to redo? [Y] / [N]: ");
            System.out.println();

        } while (repeat == 'Y');

        System.out.println("Exiting... Goodbye, " + name + "!");
        handler.close();
    }
}