import util.LoginHandle;

public class App {

    public static void main(String[] args) {
        LoginHandle login = new LoginHandle();
		
		// only enter the app if login succeeded or user chose Guest
        if (login.loginPrompt()) {
            login.mainMenu();
        }
    }
}