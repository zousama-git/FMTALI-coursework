package util;

public class BMICalculator {
	
    String name;
    int    age, unitChoice;   // 1 = Metric, 2 = Imperial
    double weight, height; // in metric

    public BMICalculator(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.unitChoice = 1; // Default to Metric
    }

    public void setUnitChoice(int unitChoice) {
        this.unitChoice = unitChoice;
    }

    public double calculateBMI() { //commented out because vaules by default are calculted in matric hence i dont need to convert to imperial to calculate bmi
        /* if (unitChoice == 1) {
            return weight / Math.pow(height, 2);
        } else {
            return (703 * (weight * 2.20462)) / Math.pow((height * 39.3701), 2);
        } */
		return weight / Math.pow(height, 2);
    }

    public void printBMICategory(double bmi) {
        System.out.print("Category : ");
        if      (bmi < 18.5) System.out.println("Underweight");
        else if (bmi < 25.0) System.out.println("Normal weight");
        else if (bmi < 30.0) System.out.println("Overweight");
        else if (bmi < 35.0) System.out.println("Obese Class I");
        else if (bmi < 40.0) System.out.println("Obese Class II");
        else System.out.println("Obese Class III");
    }

    public void displayInfo() {
        double bmi = calculateBMI();

        System.out.println("\n============= I N F O =============");
        System.out.printf("Name: %s%n", name);
		System.out.printf("Age: %d%n", age);

        if (unitChoice == 2) {
            // Convert stored metric values to Imperial
            System.out.printf("Height (in) : %.2f%n", height * 39.3701);
            System.out.printf("Weight (lbs): %.2f%n", weight * 2.20462);
        } else {
            System.out.printf("Height (m)  : %.2f%n", height);
            System.out.printf("Weight (kg) : %.2f%n", weight);
        }

        System.out.printf( "BMI : %.2f%n", bmi);
        printBMICategory(bmi);
        System.out.println("====================================\n");
    }
}