package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LaunchHomePage {
    WebDriver driver;

    @Given("user launches the browser")
    public void user_launches_the_browser() {
        System.setProperty("webdriver.chrome.driver", "../Common/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @When("user navigates to wwww.amazon.com")
    public void user_navigates_to_wwww_amazon_com() {
        driver.get("https://www.amazon.com/");
    }

    @Then("home page displayed")
    public void home_page_displayed() {
        Boolean homePageStatus = driver.findElement(By.id("nav-your-amazon")).isDisplayed();
        Assert.assertTrue(homePageStatus);
    }

}
