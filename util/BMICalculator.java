package util;

public class BMICalculator {

    String name;
    int    age, unitChoice;
    double weightKg, heightM; //always stored in metric and then can be converted for display if needed

    BMICalculator(String name, int age, double weightKg, double heightM) {
        this.name = name;
        this.age = age;
        this.weightKg = weightKg;
		this.heightM = heightM;
    }

    void setUnitChoice(int unitChoice) {
        this.unitChoice = unitChoice;
    }

	//standard BMI formula: weight/(height*height) but in metrics
    double calculateBMI() {
        return weightKg / (Math.pow(heightM,2));
    }

    String getBMICategory(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25.0) return "Normal weight";
        else if (bmi < 30.0) return "Overweight";
        else if (bmi < 35.0) return "Obese Class I";
        else if (bmi < 40.0) return "Obese Class II";
        else return "Obese Class III";
    }
	
	//prints the BMI results and then pass the logged in username or "" for guest 
    void displayInfo(String loggedInAs) {
        double bmi = calculateBMI();
        String category = getBMICategory(bmi);

        System.out.println();
        System.out.println("BMI RESULTS");
        System.out.printf( "Name: %s%n", name);
        System.out.printf( "Age: %d%n", age);

        if (unitChoice == 2) {
            double heightIn = heightM   * 39.3701;
            double weightLb = weightKg  *  2.20462;

            int feet = (int)(heightIn / 12);
            double inches   = heightIn % 12;

            System.out.printf("Height: %dft %.2fin%n", feet, inches);
            System.out.printf("Weight: %.2flbs%n", weightLb);
        } else {
            System.out.printf("Height: %.2fm%n", heightM);
            System.out.printf("Weight: %.2fkg%n", weightKg);
        }

        System.out.printf( "BMI: %-24.2f%n", bmi);
        System.out.printf( "Category: %-24s%n", category);

        if (!loggedInAs.isEmpty()) {
            System.out.printf("Session: %-24s%n", loggedInAs);
        } else {
            System.out.printf("Session: %-24s%n", "Guest");
        }

        System.out.println();
    }
}