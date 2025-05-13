package steps;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testbase.BaseClass;

import utilities.CommonMethods;
import utilities.ConfigsReader;


public class LoginPageValidationStep extends CommonMethods {
	
	
	@Given("as an Admin I validate username,password and login button is visible")
	public void as_an_admin_i_validate_username_password_and_login_button_is_visible() {
	  
	    WebElement actualname=loginPage.userNameText ;
	   
	    WebElement actualpassword=loginPage.passwordText;
	    
	    WebElement actualbutton=loginPage.loginButton;
	    
	    if(actualname.isDisplayed()) 
	    {
	    	System.out.println("Username text is visible");
	    }else
	    {
	    	System.out.println("Username text is NOT visible");
	    }
	    
	    if(actualpassword.isDisplayed()) 
	    {
	    	System.out.println("Password text is visible");
	    }else
	    {
	    	System.out.println("Password text is NOT visible");
	    }
	    
	    if(actualbutton.isDisplayed()) 
	    {
	    	System.out.println("Button text is visible");
	    }else
	    {
	    	System.out.println("Button text is NOT visible");
	    }
	}
	@When("I enter a valid username and valid password")
	public void i_enter_a_valid_username_and_valid_password() {
	    sendText(loginPage.userName,ConfigsReader.getProperty("username"));
	    sendText(loginPage.password,ConfigsReader.getProperty("password"));
	}
	@When("I enter login button")
	public void i_enter_login_button() {
		 loginPage.loginButton.click();
	}
	@Then("Student Information System should be visible")
	public void student_information_system_should_be_visible() {
		
		
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='Header1_lblSIS']")));
	   String expectedstudentvalidate = "Student Information System";
	   String actualstudentvalidate =homePage.studentInfoText.getText();
	   
	   if(actualstudentvalidate.equals(expectedstudentvalidate)) 
	   {
		   System.out.println("With correct username and password login in to the system is succesful");
	   }else 
	   {
		   System.out.println("Login in to the system is failed");
	   }
	}
 
	@When("I enter a valid username and wrong password")
	public void i_enter_a_valid_username_and_wrong_password() {
	    sendText(loginPage.userName,ConfigsReader.getProperty("username"));
	    sendText(loginPage.password,ConfigsReader.getProperty("password1"));
	}
	
	@When("I enter a wrong username and valid password")
	public void i_enter_a_wrong_username_and_valid_password() {
		sendText(loginPage.userName,ConfigsReader.getProperty("username1"));
	    sendText(loginPage.password,ConfigsReader.getProperty("password"));
	}

	@When("I enter a wrong username and wrong password")
	public void i_enter_a_wrong_username_and_wrong_password() {
		sendText(loginPage.userName,ConfigsReader.getProperty("username1"));
	    sendText(loginPage.password,ConfigsReader.getProperty("password1"));
	}
	
	@Then("Student Information System should not be visible")
	public void student_information_system_should_not_be_visible() {
		wait(2);
		String alert =BaseClass.driver.switchTo().alert().getText();
		 String expectedalert="Either username and password do not match or your account doesn't have  access for the selected Academic Year.";
		if(alert.contains(expectedalert)) 
		{
			System.out.println("With unvalid credentials login failed.TEST PASSED!");
		}
		
	}
	
	



}
