package vtiger.Practise;

import org.testng.annotations.Test;

public class ArgumentsFromCMDPROMT {

	

	@Test
	public void login()
	{
		String username=System.getProperty("username");
		String password=System.getProperty("password");
		
		System.out.println("Enter the username-"+username);

		System.out.println("Enter the password-"+password);
	}
	
}
