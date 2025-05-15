package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/feature/",

		glue = "steps",

		dryRun = false,

		monochrome = true,

		tags = "@StudentsPageValidation",

		plugin = {

				"pretty", 
				
				"json:target/cucumber.json",

				"html:target/cucumber-reports.html"

		}

)

public class TestRunner {

}
