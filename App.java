import util.Input;
import util.LoginHandle;

public class App {

    public static void main(String[] args) {
		Input handler  = new Input();
		LoginHandle login = new LoginHandle();
        
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