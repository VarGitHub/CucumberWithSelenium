package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public static WebDriver driver = null;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "../Common/driver/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void cleanUp() {
        this.driver.quit();
    }
}
