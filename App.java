import util.Input;
import util.BMICalculator;
import util.UserDatabase;
import util.LoginHandle;

public class App {

    public static void main(String[] args) {
		Input handler  = new Input();
		LoginHandle login = new LoginHandle();
		UserDatabase userDB = new UserDatabase();
        
		while (true) {
            if (login.loginPrompt()) {
                break;
            }
        }
        
		login.runBMI();
        login.printGoodbye();
        handler.close();
    }
}