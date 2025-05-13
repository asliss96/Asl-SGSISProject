package testbase;

import pages.LoginPageElements;

public class pageInitializer extends BaseClass {
	
	public static LoginPageElements loginPage;
	
	
	public static void initialize() 
	{
		loginPage = new LoginPageElements();
	}

}
