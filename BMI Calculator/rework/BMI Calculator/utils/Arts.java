public class Arts{
	public void inboxText(String text){
	String dash = "";
		for (int i = 0; i<text.length();i++) dash += "═";
		
		System.out.printf	("╔═%s═╗\n", dash);
		System.out.printf	("║ %s ║\n", text);
		System.out.printf	("╚═%s═╝\n", dash);
	}
	
	public void setColour(String colour, String text){
		String colourChoice = "";
		
		switch (colour){
			case "green" -> colourChoice = "\u001B[32m";
			case "yellow" -> colourChoice = "\u001B[33m";
			case "red" -> colourChoice = "\u001B[31m";
			case "cyan" -> colourChoice = "\u001B[36m";
			default -> colourChoice = "\u001B[0m";
		}
		
		StringBuilder colouring = new StringBuilder();
		colouring.append(colourChoice).append(text).append("\u001B[0m");
		String coloured = colouring.toString();
		
		System.out.print(coloured);
	}
	
	public void bar(double BMI){
		int iBMI = (int) Math.round(BMI);
		
		System.out.println("\u001B[31m----------\u001B[33m--------\u001B[32m-------\u001B[33m----------\u001B[31m-----");
		String pos = "";
		for (int i=0; i<iBMI;i++) pos+=" ";
		System.out.println(pos + "\u001B[95m^\u001B[0m");
	}
}