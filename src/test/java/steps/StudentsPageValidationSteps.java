package steps;



import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.CommonMethods;

public class StudentsPageValidationSteps extends CommonMethods {
	
	@When("I navigate to Students tab")
	public void i_navigate_to_students_tab() {
	    wait(3);
	    click(studentsPage.studentstab);
	}
	@Then("I validate these subtabs are visible")
	public void i_validate_these_subtabs_are_visible(io.cucumber.datatable.DataTable dataTable) {
	    String allTabsText = studentsPage.studentstabs.get(0).getText(); // tüm sekmeler tek bir alanda olabilir

	    for (String expected : dataTable.asList()) {
	        if (allTabsText.contains(expected)) {
	            System.out.println("✅ Found: " + expected);
	        } else {
	            System.out.println("❌ Not Found: " + expected);
	            throw new AssertionError("Missing tab: " + expected);
	        }
	    }
	}
	    }
	

