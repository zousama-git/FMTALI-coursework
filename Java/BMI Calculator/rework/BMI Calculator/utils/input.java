	public void access(){
		art.setColour("blue","[1]"); System.out.println(" Log In");
		art.setColour("blue","[2]"); System.out.println(" Create Account");
		art.setColour("blue","[3]"); System.out.println(" Continue as Guest");
		art.setColour("blue","[4]"); System.out.println(" Exit");
		System.out.println("Your choice -> ");
	}
	
	public void logIn(){
		art.setColour("blue","Username: "); 
		art.setColour("blue","Password: ");
		art.setColour("blue","Name: ");
		art.setColour("blue","Age: ");
		art.setColour("blue","Gender (M/F): ");
		art.setColour("blue","Height: ");
		art.setColour("blue","Weight: ");
		
	}
	
	public void newAccount(){
		art.setColour("blue","Username: "); System.out.println(" Log In");
		art.setColour("blue","Password: "); System.out.println(" Create Account");
	}