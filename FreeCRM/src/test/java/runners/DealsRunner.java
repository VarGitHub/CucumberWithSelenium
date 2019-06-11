package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/featurefiles/deals.feature",
        glue = "stepdefinitions",
        dryRun = false
)
public class DealsRunner extends AbstractTestNGCucumberTests {
}
