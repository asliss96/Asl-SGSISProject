package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.BaseClass;
import utilities.CommonMethods;

public class HomePageElements extends CommonMethods{
	
	@FindBy(xpath="//span[@id='Header1_lblSIS']")
	public WebElement studentInfoText;
	
	
	
	
	public HomePageElements() {
		 
	    PageFactory.initElements(BaseClass.driver, this);
	}
	

}
