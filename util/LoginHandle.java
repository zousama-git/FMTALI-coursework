package util;

public class LoginHandle {
    Input handler;
    UserDatabase userDB;

    public LoginHandle() {
        this.handler = new Input();
        this.userDB = new UserDatabase();
    }

    public void printGoodbye() {
        String who = userDB.isLoggedIn() ? userDB.getLoggedInUser() : "Guest";
        System.out.printf("Goodbye, %-27s%n", who + "!");
        System.out.println("Stay healthy and take care!");
    }

    public boolean loginPrompt() {
        System.out.println("ACCESS MENU");
        System.out.println("[1] Log in");
        System.out.println("[2] Continue as Guest");
        System.out.println("[3] Exit");
        System.out.print("Your choice: ");

        int choice = (int) handler.getValidInput("", 1, 3);

        if (choice == 1) {
            handleLogin();
            return userDB.isLoggedIn();
        } else if (choice == 2) {
            return true;
        } else {
            System.out.println("\nGoodbye!");
            handler.close();
            System.exit(0);
        }
        return false;
    }

    void handleLogin() {
        System.out.println("\nLogin");
        System.out.println("(Only existing accounts are allowed.)");
        System.out.println("(Type 'cancel' as username to go back.)");
        System.out.println();

        while (true) {
            String username = handler.getUsername();
            if (username.equals("cancel")) {
                return;
            }
            String password = handler.getPassword();

            if (userDB.login(username, password)) {
                System.out.println("\nLogin successful! Welcome, " + username + ".");
                return;
            } else {
                System.out.println("\nInvalid username or password. Please try again.\n");
            }
        }
    }

    public void logout() {
        String user = userDB.getLoggedInUser();
        userDB.logout();
        System.out.println("\nYou have been logged out. Goodbye, " + user + "!");
    }

    public void runBMI() {
        System.out.println("Hello! Let's calculate your BMI.");
        System.out.println("(Metric units are used for input. You can view in Imperial later.)");
        System.out.println();

        String name;
        if (userDB.isLoggedIn()) {
            name = userDB.getLoggedInUser();
        } else {
            name = handler.getString("Enter your name: ");
        }

        int age = (int) handler.getValidInput("Enter your age: ", 1, 120);
        double height = handler.getValidInput("Enter height (cm): ", 50, 300) / 100.0;
        double weight = handler.getValidInput("Enter weight (kg): ", 10, 600);

        BMICalculator bmi = new BMICalculator(name, age, weight, height);

        char repeat;
        do {
            System.out.println();
            int unitChoice = handler.getUnitChoice();
            bmi.setUnitChoice(unitChoice);
            bmi.displayInfo(userDB.isLoggedIn() ? userDB.getLoggedInUser() : "");

            repeat = handler.getCharInput("Redo with different units? [Y / N]: ");
            System.out.println();
        } while (repeat == 'Y');
    }

    public void mainMenu() {
        while (true) {
            System.out.println("\nMAIN MENU");
            System.out.println("[1] Calculate BMI");
            if (userDB.isLoggedIn()) {
                System.out.println("[2] Log out");
            } else {
                System.out.println("[2] Log in");
            }
            System.out.println("[3] Exit");
            System.out.print("Your choice: ");

            int choice = (int) handler.getValidInput("", 1, 3);

            if (choice == 1) {
                runBMI();
            } else if (choice == 2) {
                if (userDB.isLoggedIn()) {
                    logout();
                } else {
                    handleLogin();
                }
            } else {
                printGoodbye();
                handler.close();
                return;
            }
        }
    }
}