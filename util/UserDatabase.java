package util;

public class UserDatabase {

    static String[] usernames = {
        "alice",
        "bob",
        "charlie",
        "diana",
        "eve"
    };

    static String[] passwords = {
        "pass123",
        "qwerty",
        "hello99",
        "sunshine",
        "qwerty123"
    };

    String loggedInUser = "";

    public boolean login(String username, String password) {
        for (int i = 0; i < usernames.length; i++) {
            if (usernames[i].equals(username) && passwords[i].equals(password)) {
                loggedInUser = usernames[i];
                return true;
            }
        }
        return false;
    }

    public boolean isLoggedIn() {
        return !loggedInUser.equals("");
    }

    public String getLoggedInUser() {
        return loggedInUser;
    }

    public void logout() {
        loggedInUser = "";
    }
}