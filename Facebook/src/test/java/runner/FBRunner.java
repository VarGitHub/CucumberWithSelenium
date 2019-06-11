package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

@CucumberOptions(features = "src/test/resources/features", glue = {"steps"})
public class FBRunner extends AbstractTestNGCucumberTests {

    public static WebDriver driver = null;

    //@BeforeClass
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "../Common/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterClass
    public void cleanUp() {
        driver.quit();
    }

}
