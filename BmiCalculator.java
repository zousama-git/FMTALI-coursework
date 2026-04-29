import java.util.Scanner;
import java.util.Locale;

public class BmiCalculator{

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		input.useLocale(Locale.US);
		
		char repeat = 0;
		
		do{
			
			int unitChoice = getUnitChoice(input);
			
			double weight = (unitChoice == 1) ? getValidInput(input, "Enter your weight in Kilograms: ", 10, 600)
					: getValidInput (input, "Enter your weight in pounds: ", 22, 1300);
			double height = (unitChoice == 1) ? getValidInput(input, "Enter your height in meters: ", 0.5, 2.5)
					: getValidInput (input, "Enter your height in inches: ", 20, 100);
			
			double bmi = calculateBMI(unitChoice, weight, height);
			System.out.print("Your BMI is :"+bmi);
			
			//repeat = askToRepeat(input);
			System.out.println();
			
		} while(repeat == ('Y') || repeat == ('y'));
		
		
	}
	
	public static int getUnitChoice(Scanner input){
		int choice;
		
		while (true){
			System.out.println("Select a preferred unit:\n"
			+ "1. Metric (kg, m)\n"
			+("2. Imperial (lbs, in)\n"
			+("Please select either option 1 or option 2")));
			
			if (input.hasNextInt()){
				choice = input.nextInt();
				if (choice == 1 || choice == 2){
					break;
				} else {
					System.out.print("Invalid choice. Please enter either 1 or 2");
				}
			} else {
				System.out.print("Invalid choice. Please enter either 1 or 2");
				input.next();
			}
		}
		
		return choice;
	}
	
	public static double getValidInput (Scanner input, String prompt, double min, double max){
		double value;
		
		while (true){
			
			System.out.println(prompt);
			
			if (input.hasNextDouble()){
				value = input.nextDouble();
				if(value >= min && value <= max){
					break;
				} else{
					System.out.printf("Please enter a value between %.1f and %.1f.\n", min,max);
				}
			} else{
				System.out.println("Invalid input. Please enter a value.");
				input.next();
			}
		}
		
		return value;
	}
	
	public static double calculateBMI(int unitChoice, double weight, double height){
		double totalBMI;
		if (unitChoice == 1){
			totalBMI = weight/Math.pow(height,2);
		} else {
			totalBMI = (703 * weight)/(height/height);
			}
		return totalBMI;
	}
	
}