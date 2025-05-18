package steps;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.CommonMethods;

public class AddNewStudentStep extends CommonMethods {
	
	Alert alert;
	
	
	@When("I enter the Add new button")
	public void i_enter_the_add_new_button() {
	    personalPage.addNewButton.click();
	    wait (3);
	}
	@When("I fill all textboxes except local id, username and grade section with the following data:")
	public void i_fill_all_textboxes_except_local_id_username_and_grade_section_with_the_following_data(io.cucumber.datatable.DataTable dataTable) {
	    List<Map<String,String>> personalbox =dataTable.asMaps();
	     for (Map <String,String> p :personalbox) 
	     {
	    	 personalPage.stateId.sendKeys(p.get("State Id"));
	    	 personalPage.lastName.sendKeys(p.get("Last Name"));
	    	 wait(2);
	    	 personalPage.firstName.sendKeys(p.get("First Name"));
	    	 personalPage.SSN.sendKeys(p.get("SSN"));
	    	 personalPage.email.sendKeys(p.get("Email"));
	    	 wait(2);
	    	 
	    	 personalPage.password.sendKeys(p.get("Password"));
	    	 wait(2);
	     }

	}
	@When("I click submit changes")
	public void i_click_submit_changes() {
		wait(2);
	   click(personalPage.submitb);
	   wait(2);
	}
	
	@Then("I validate the student is saved succesfully")
	public void i_validate_the_student_is_saved_succesfully() {
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	  Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	   driver.switchTo().alert();
	  String succesm=alert.getText();
	  alert.accept();
	  System.out.println("This is the the validation for adding a new student"+ succesm);
	  assertTrue(succesm.contains("Successfully"));
	  
	}

	private void assertTrue(boolean contains) {
		// TODO Auto-generated method stub
		
	}
	@When("click Click to change to add photo")
	public void click_click_to_change_to_add_photo() {
		 personalPage.photoadd.click();

		    // Store current window
		    String mainWindow = driver.getWindowHandle();

		    // Wait for new window to open
		    new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(driver -> driver.getWindowHandles().size() > 1);

		    // Switch to new window
		    for (String handle : driver.getWindowHandles()) {
		        if (!handle.equals(mainWindow)) {
		            driver.switchTo().window(handle);
		            break;
		        }
		    }

		    // Wait for file input and upload file
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement fileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fileUpload")));
		    fileInput.sendKeys("C:\\Users\\aslis\\OneDrive\\Masaüstü\\p.jpg");

		    // Click upload button (if needed)
		    personalPage.uploadb.click();

		    // Wait and handle alert
		    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		    String fileuploadm = alert.getText();
		    alert.accept();

		    // Assertion
		    Assert.assertTrue("Upload message mismatch: " + fileuploadm, fileuploadm.contains("Successfully"));

		    // Return to main window
		    driver.switchTo().window(mainWindow);
	}
	
	@Then("I save username and password")
	public void i_save_username_and_password() {
	    String studentsPassword = personalPage.password.getAttribute("value");
	    String studentsUsername = personalPage.username.getAttribute("value");
	    System.out.println("Save for other scenarios username: " + studentsUsername + " and password: " + studentsPassword);
	}
}
