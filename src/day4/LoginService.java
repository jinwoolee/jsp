package day4;

public class LoginService {
	
	public boolean loginProcess(String userId, String pass){
		
		if(pass.equals("admin"))
			return true;
		else
			return false;
	}
}
