package steps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testbase.BaseClass;
import utilities.CommonMethods;

public class Hooks extends CommonMethods {
	
	@Before
	public void start() 
	{
		BaseClass.setUp();
	}
	
	@After
	public void end(Scenario scenario)
	{
		
		 try {
		       
		        Alert alert = BaseClass.driver.switchTo().alert();
		        System.out.println("Alert found: " + alert.getText());
		        alert.accept();  
		    } catch (NoAlertPresentException e) {
		        
		    }
		
		    byte[] screenshot = null;
		    
		    if (scenario.isFailed()) {
		        screenshot = takeScreenshot("failed/" + scenario.getName());
		    } else {
		        screenshot = takeScreenshot("passed/" + scenario.getName());
		    }
		    
		    if (screenshot != null) {
		        scenario.attach(screenshot, "image/png", scenario.getName());
		    }

		    BaseClass.tearDown();  
		}
	}


