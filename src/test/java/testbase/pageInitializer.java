package testbase;

import pages.HomePageElements;
import pages.LoginPageElements;
import pages.StudentsPageElements;

public class pageInitializer extends BaseClass {
	
	public static LoginPageElements loginPage;
	public static HomePageElements homePage;
	public static StudentsPageElements studentsPage;
	
	
	public static void initialize() 
	{
		loginPage = new LoginPageElements();
		homePage =new HomePageElements();
		studentsPage=new  StudentsPageElements();
	}

}
