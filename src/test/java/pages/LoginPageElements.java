package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.BaseClass;
import utilities.CommonMethods;
import utilities.ConfigsReader;

public class LoginPageElements extends CommonMethods{
	
	@FindBy(xpath="//input[@id='tUsername']")
	public WebElement userName;
	
	@FindBy(xpath="(//td[@align='right'])[1]")
	public WebElement userNameText;
	
	@FindBy(xpath="//input[@id='tPassword']")
	public WebElement password;
	
	@FindBy(xpath="(//td[@align='right'])[2]")
	public WebElement passwordText;
	
	@FindBy(id="bLogin")
	public WebElement loginButton;
	
	@FindBy(xpath="//span[@id='Header1_lblSIS']")
	public WebElement studentInfoText;
	
	
	public LoginPageElements() {
	 
	    PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void adminLogin() 
	{
		sendText(userName,ConfigsReader.getProperty("username"));
		sendText(password,ConfigsReader.getProperty("password"));
		click(loginButton);
	}

}
