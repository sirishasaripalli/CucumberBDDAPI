package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/post.feature",
        glue = {"stepDefinitions"},
        monochrome = true,
        //tags = "@tag1",
     	plugin = {"pretty"}
               
        )
public class TestRunner {
}