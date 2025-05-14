package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static testbase.pageInitializer.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import io.cucumber.java.en.Then;
import testbase.BaseClass;
import utilities.CommonMethods;


public class SuccesfulLoginAndHomePageValidationStep extends CommonMethods {
	
	@Then("I validate MainPage subtab is visible")
	public void i_validate_main_page_subtab_is_visible() {
		try{
			Assert.assertTrue("Main Page subtab should be visible", homePage.mainPageIcon.isDisplayed());
			}
		catch (NoSuchElementException e) {
		    Assert.fail("Main Page subtub is not present in the DOM.");
		    }
	}
	@Then("I validate Announcements section is visible")
	public void i_validate_announcements_section_is_visible() {
	    try
	    {
	    	Assert.assertTrue("announcements section is visible",homePage.announcements.isDisplayed());
	    }catch(NoSuchElementException e){
	    	Assert.fail("announcements section is not present in the DOM.");
	    }
	}
	@Then("I Validate that the logo is visible")
	public void i_validate_that_the_logo_is_visible() {
		 try
		    {
		    	Assert.assertTrue("logo section is visible",homePage.logo.isDisplayed());
		    }catch(NoSuchElementException e){
		    	Assert.fail("Logo  is not present in the DOM.");
		    }
	}
	
	@Then("I validate that the URL includes the MainPage.aspx extension")
	public void i_validate_that_the_url_includes_the_main_page_aspx_extension() {
	    String currentUrl = driver.getCurrentUrl();
	    
	    Assert.assertTrue(currentUrl.contains("MainPage.aspx"));
	}

	@Then("I validate MainPage subtab is NOT visible")
	public void i_validate_main_page_subtab_is_not_visible() {
	    
	    List<WebElement> subTab = driver.findElements(By.xpath("//span[text()='Main Page']"));
	    Assert.assertTrue("Main Page subtab is unexpectedly visible", subTab.isEmpty());
	}

	@Then("I validate Announcements section is NOT visible")
	public void i_validate_announcements_section_is_not_visible() {
	   
	    List<WebElement> announcements = driver.findElements(By.xpath("//table[@class='blockMid']//span"));
	    Assert.assertTrue("Announcements section is unexpectedly visible", announcements.isEmpty());
	}

	@Then("I Validate that the logo is NOT visible")
	public void i_validate_that_the_logo_is_not_visible() {
	   
	    List<WebElement> logos = driver.findElements(By.id("Header1_imgSchoolLogo"));
	    Assert.assertTrue("Logo is unexpectedly visible", logos.isEmpty());
	}

	@Then("I validate that the URL does not include the MainPage.aspx extension")
	public void i_validate_that_the_url_does_not_include_the_main_page_aspx_extension() {
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertFalse("URL should NOT contain 'MainPage.aspx'", currentUrl.contains("MainPage.aspx"));
	}
}