package model;

public class Utilities {
	
	public static boolean authenticateUser(String username, String password, UserStorage userStorage) {
		if(userStorage.containsUser(username)) {
			User u = userStorage.searchUser(username);
			if(password.equals(u.getPassword()) && u.isActive()) {
				return true;
			}
		}
		return false;
	}
}
