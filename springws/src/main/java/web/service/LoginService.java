package web.service;

public class LoginService {
	public static boolean login(String username, String password, String dob) {
		if ("hitesh".equals(username) && "112233".equals(password) && "2004-11-05".equals(dob)) {
			return true;
		}
		return false;	
	}
}