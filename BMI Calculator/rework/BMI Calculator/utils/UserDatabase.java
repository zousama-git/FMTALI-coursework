import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDatabase{
	public String [] dates, usernames, passwords, names;
	public Integer [] ages;
	public Double [] heights, weights;
	
	public void addLoginDate(String x){
		dates = new String[] {"21/09/2025", "20/03/2026", "11/01/2026"};
		ArrayList<String> tempo = new ArrayList<>(Arrays.asList(dates));
		tempo.add(x);
		dates = tempo.toArray(new String[3]);
	}
	
	public void addUsername(String x){
		usernames = new String[]{"alice", "dave", "john"};
		ArrayList<String> tempo = new ArrayList<>(Arrays.asList(usernames));
		tempo.add(x);
		usernames = tempo.toArray(new String[3]);
	}
	
	public void addPassword(String x){
		passwords = new String[]{"pass123", "king999", "Qwerty1212"};
		ArrayList<String> tempo = new ArrayList<>(Arrays.asList(passwords));
		tempo.add(x);
		passwords = tempo.toArray(new String[3]);
	}
	
	public void addName(String x){
		names = new String[]{"Alice", "Dave", "John"};
		ArrayList<String> tempo = new ArrayList<>(Arrays.asList(names));
		tempo.add(x);
		names = tempo.toArray(new String[3]);
	}

	public void addAge(int x){
		Integer age = x; 
		ages = new Integer[]{21, 24, 18};
		ArrayList<Integer> tempo = new ArrayList<>(Arrays.asList(ages));
		tempo.add(age);
		ages = tempo.toArray(new Integer[3]);
	}
	
	public void addHeight(double x){
		Double height = x; 
		heights = new Double[]{170.00, 165.00, 155.00};
		ArrayList<Double> tempo = new ArrayList<>(Arrays.asList(heights));
		tempo.add(height);
		heights = tempo.toArray(new Double[3]);
	}
	
	public void addWeight(double x){
		Double weight = x; 
		weights = new Double[]{50.00, 60.00, 70.00};
		ArrayList<Double> tempo = new ArrayList<>(Arrays.asList(weights));
		tempo.add(weight);
		weights = tempo.toArray(new Double[3]);
	}
}