import util.LoginHandle;

public class App {

    public static void main(String[] args) {
        LoginHandle login = new LoginHandle();

        if (login.loginPrompt()) {
            login.mainMenu();
        }
    }
}