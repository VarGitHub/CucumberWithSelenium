package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/FeatureFiles/AmazonLogin.feature",
        glue = "stepdefinitions"
)
public class AmazonRunner extends AbstractTestNGCucumberTests {
}
