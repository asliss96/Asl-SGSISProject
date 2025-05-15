package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.BaseClass;


public class StudentsPageElements  {
	
	
	@FindBy (xpath ="//*[@id=\"form1\"]/table[3]/tbody/tr/td[3]/table[1]/tbody/tr[1]/td/table")
	public List<WebElement> studentstabs ;
	
	@FindBy(linkText="Students")
	public WebElement studentstab;
	
	
	
	
	
	public StudentsPageElements() 
	{
	   PageFactory.initElements(BaseClass.driver, this);
	}

}
