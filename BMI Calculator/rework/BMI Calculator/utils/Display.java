public class Display{
	Arts art = new Arts();
	
	public void banner(){
        String[] lines = {
                "#   #  #####   ###   #     #####  #   #",
                "#   #  #      #   #  #       #    #   #",
                "#####  ####   #####  #       #    #####",
                "#   #  #      #   #  #       #    #   #",
                "#   #  #####  #   #  #####   #    #   #"
        };

        int max = 0;
        for (String line : lines) {
            max = Math.max(max, line.length());
        }

        String dash = "═".repeat(max + 2);
        System.out.println("\u001B[36m"); // cyan
        System.out.println("╔" + dash + "╗");

        for (String line : lines) {
            System.out.printf("║ %-"+ max +"s ║%n", line);
        }

        System.out.println("╚" + dash + "╝");
        System.out.print("\u001B[0m"); // reset
		
		art.setColour("dim","      BEING HEALTHY IS COOL! BE COOL!!!");
		System.out.println("");
		art.line();
	}
	
	public void header(String text){
		art.line();
		System.out.println("\u001B[36m");
		art.inboxText("blue",text.toUpperCase);
		System.out.print("\u001B[0m\n");
	}
	
	public void logIn(){
		art.line();
		System.out.println("\u001B[36m");
		art.inboxText("blue","LOGIN");
		System.out.print("\u001B[0m\n");
	}
	
		public void access(){
		art.setColour("blue","[1]"); System.out.println(" Log In");
		art.setColour("blue","[2]"); System.out.println(" Create Account");
		art.setColour("blue","[3]"); System.out.println(" Continue as Guest");
		art.setColour("blue","[4]"); System.out.println(" Exit");
		System.out.println("Your choice -> ");
	}
	
	public void mainMenu(){
		art.setColour("blue","[1]"); System.out.println(" BMI Health Check");
		art.setColour("blue","[2]"); System.out.println(" BAR");
		art.setColour("blue","[3]"); System.out.println(" Health Tips");
		art.setColour("blue","[4]"); System.out.println(" Exit");
		System.out.println("Your choice -> ");
	}
	
	public void logOut(){
		art.line();
		System.out.println("Goodbye, there!");
		art.setColour("dim","Stay healthy. See you next time. 💙"); 
		art.line();
		System.exit(0);

	}
	
}