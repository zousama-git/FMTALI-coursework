import java.util.Scanner;
import util.BMICalculator;

public class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String name = input.nextLine();
		
		System.out.print("Enter your age: ");
		int age = input.nextInt();
		
		System.out.print("Enter your height (cm): ");
		double height = (input.nextDouble())/100;
		input.nextLine();
		
		System.out.print("Enter your weight: ");
		double weight = input.nextDouble();
		input.nextLine();
		
		BMICalculator bmi = new BMICalculator(age, weight, height, name);
		
		char option2 = 'Y';
		
		do{
			bmi.option();
			char option = input.next().charAt(0);
		
			BMICalculator optionBMI = new BMICalculator(option);
			bmi.displayInfo();
		
			System.out.print("Do you want to redo? : [Y]/[N]\n");
			option2 = input.next().charAt(0);
			if (option2 == 'N'){
				bmi.close();
			}else{continue;}
		} while (option2 != 'N');
		
		input.close();
	}
}