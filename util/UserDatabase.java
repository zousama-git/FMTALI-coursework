package util;

public class UserDatabase {
	/*
		parallels arrays
		they use the same index to for both account and password
	*/
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
	
	//empty string means no user is logged in, hence guest mode
    String loggedInUser = "";
	
	//returns true and stores the username if the creidentials match, but otherwise return false 
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
	
	//clears the logged in user, hence returning the session to guest mode
    public void logout() {
        loggedInUser = "";
    }
}