package Utility;

public class Verification {
	public boolean verifyLogin(String username,String password) {
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			return true;
		}
		else {
			return false;
			
		}
	}
	public boolean validEmail(String email) {
		
		 String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		 return email.matches(regex);
	}
	
}
