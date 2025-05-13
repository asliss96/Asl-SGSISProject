package testbase;

import pages.HomePageElements;
import pages.LoginPageElements;

public class pageInitializer extends BaseClass {
	
	public static LoginPageElements loginPage;
	public static HomePageElements homePage;
	
	
	public static void initialize() 
	{
		loginPage = new LoginPageElements();
		homePage =new HomePageElements();
	}

}
