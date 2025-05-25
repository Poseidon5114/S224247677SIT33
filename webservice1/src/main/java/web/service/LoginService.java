package web.service;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {

	/**
	 * Static method returns true for successful login, false otherwise.
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean login(String username, String password, String dob) {
		// Match a fixed user name and password.
		//
		if ("Hitesh".equals(username) && "Goodgod@11".equals(password)) {
			return true;
		}
		return false;
	}
	
	
}
