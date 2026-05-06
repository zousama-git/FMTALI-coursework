import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Calculations{
	public double BMI(double weight, double height){
		return weight/Math.pow(height,2);
	}
	
	public double toImperialWeight(double weight){
		return weight*=2.20462;
	}
	
	public double toImperialHeight(double height){
		return height*=3.28084;
	}
	
	public Period dateDifference(String date){
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate newDate = LocalDate.parse(date, format);

		Period dateApart = Period.between(newDate, currentDate);

		return dateApart;
	}
	
	public boolean hasImproved(double oldBMI, double newBMI){
		if (oldBMI<newBMI && newBMI<18.5){
			return improved = true;
		} else if(oldBMI>newBMI && newBMI>29.5)
			return improved = true;
		else if (oldBMI>newBMI||oldBMI>newBMI && (newBMI<18.5 &&newBMI>29.5))
			improved = true;
		else improved = false;
	}
}