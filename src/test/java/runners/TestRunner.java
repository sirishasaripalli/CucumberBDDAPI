package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/End2End.feature",
        glue = {"stepDefinitions"},
        monochrome = true,
        //tags = {"@tag1" "@tag2"},
        
     	plugin = {"pretty","html:target/cucumber-reports.html",
				}
               
        )
public class TestRunner {
}