package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.BaseClass;

public class StudentsPersonalElements {

	@FindBy(xpath="//input[@value='Add New']")
	public WebElement addNewButton;
	
	@FindBy(name="tStateId")
	public WebElement stateId;
	
	@FindBy(id="tLastName")
	public WebElement lastName;
	
	@FindBy(id="tFirstName")
	public WebElement firstName;
	
    @FindBy(name="tUsername")
    public WebElement username;

	@FindBy(id="tSSN")
	public WebElement SSN;
	
	@FindBy(id="tEmail")
	public WebElement email;
	

	@FindBy(id="tBirthDay")
	public WebElement birthDay;
	
	@FindBy(name="tPassword")
	public WebElement password;
	
	@FindBy(name="bSubmit")
	public WebElement submitb;
	
	@FindBy(linkText="Click to Change")
	public WebElement photoadd;
	
	@FindBy(id="fileUpload")
	public WebElement upload;
	
	@FindBy(id="bSubmit")
	public WebElement uploadb;
	
	
	
	
	
	
	
	public StudentsPersonalElements()
	{
		PageFactory.initElements(BaseClass.driver,this);
	}
}
