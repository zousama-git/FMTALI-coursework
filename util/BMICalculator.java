package util;

public class  BMICalculator{
	double bmi, weight, height;
	String name;
	int age;
	char option;
	
	public BMICalculator(int age, double weight, double height, String name){
		this.weight = weight;
		this.age = age;
		this.height = height;
		this.name = name;
	}
	
	public BMICalculator(char option){
		this.option = option;
	}
	
	public void displayInfo(){
		System.out.println("============= I N F O ================");
		System.out.printf("Name: %s\n", name);
		System.out.printf("Age: %d\n", age);
		System.out.printf("Height (m): %.2f\n", height);
		System.out.printf("Weight: %.2f\n", weight);	
		System.out.printf("Your BMI is: %.2f\n",bmiCalculate());		
	}
	
	public static void option(){
		System.out.println("Matric System [M]		Imperical System[I]");
		System.out.print("Enter your option here: ");
	}
	
	public static void close(){
		System.out.print("Exiting the terminal...");
		System.exit(0);
	}
	
	public double bmiCalculate(){
		if (option == 'M'){
			bmi = weight/Math.pow(height,2);
		} else {
			bmi = (weight*703)/Math.pow(height,2);
		}
		return bmi;
	}
	
	public void determineBMICategory(){
		if (bmi < 18.5) {
			System.out.print("Underweight");
		} else if(bmi < 24.9){
			System.out.print("Normal weight");
		} else if(bmi < 29.9){
			System.out.print("Overweight");
		} else if(bmi < 34.9){
			System.out.print("Obese Class 1");
		}else if(bmi < 39.9){
			System.out.print("Obese Class 2");
		} else{
			System.out.print("Obese Class 3");
		}
	}
}