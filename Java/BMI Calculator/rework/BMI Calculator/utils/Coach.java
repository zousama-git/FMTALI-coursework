public class Coach{
	public void categories(double BMI){//BMI Scale (Body Mass Index)
		String category ="";
		if (BMI<18.5) category = "Underweight";
		else if (BMI<24.9) category = "Normal";
		else if (BMI<29.9) category = "Overweight";
		else if (BMI<34.9) category = "Obese (Class 1)";
		else if (BMI<34.9) category = "Obese (Class 2)";
		else if (BMI>40) category = "Obese (Class 3)";
		else category = "N/A";
	}
	
	public void compare(){ //before vs after
		if (compareBMI()==true){
			System.out.print("""
	👍 If you improved:
	“Good work - your BMI moved toward a healthier range.”
	Likely benefits:
		- Better stamina
		- Improved health markers
		- More confidence and consistency
		""");
		} else{
			System.out.print("""
	⚠️ If it got worse:
	“Something slipped - but it's fixable.”
	Check:
		- Eating habits
		- Activity levels
		- Stress/sleep
		- Adjust small habits first (don't overhaul everything at once)
		""");
		}
		
	}
	
	public void reminder(){
		System.out.print("""
	🧠 Coaching Mindset:
	- BMI is a signal, not a verdict
	- Focus on habits, not just the number
	- Small consistent improvements > drastic short-term changes
		""");
	}
	
	public void warning(){ //What Your BMI Number Means
		System.out.print("""
	It's a quick screening tool, not a diagnosis.
	It estimates body fat risk, not exact body composition.
	Athletes or muscular people may read "overweight" but be healthy.
	It's best used alongside waist size, fitness, and lifestyle habits.
		""");
	}
	
	public void state(double BMI){ //Dangers
		if (BMI<18.5){
			System.out.print("""
	Low BMI (underweight)
		- Nutrient deficiencies
		- Weak immune system
		- Muscle loss
		- Hormonal issues
			""");
		}else if(BMI<29.9){
			System.out.print("""
	You healthy! Keep it up!
		- Lower disease risk
		- Better energy and mood
		- Improved mobility and fitness
		- More stable long-term health
			""");
		} else{
			System.out.print("""
	High BMI (overweight/obese):
		- Increased risk of:
		- Heart disease
		- Type 2 diabetes
		- High blood pressure
		- Joint strain
		- Lower energy, poorer sleep, reduced mobility
			""");	
		}
	}
	
	public void Improve(double BMI){
		if (BMI<18.5 || BMI>29.9){
			System.out.print("""
	🏃 Exercise
	- Aim for 150-300 mins/week moderate activity
	- Include:
		- Cardio (walking, cycling, running)
		- Strength training (2-3x/week)
		- Start simple: consistency beats intensity

	🥗 Food
	- Focus on:
		- Whole foods (vegetables, fruit, lean protein, whole grains)
		- Balanced meals (protein + carbs + healthy fats)
	- Reduce:
		- Ultra-processed foods
		- Sugary drinks
		- Adjust based on goal:
		- Lose weight: slight calorie deficit
		- Gain weight: calorie surplus with protein
			""");
		}else{
			System.out.print("""
	Keep routine consistent (don't “stop because it's working”)
		- Progress gradually:
			- Increase strength
			- Improve endurance
		- Watch other markers:
			- Waist size
			- Fitness level
			- Sleep quality
			""");
		}
	}
}