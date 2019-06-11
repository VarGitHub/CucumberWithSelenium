package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.DealsPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class DealsSteps {

    public WebDriver driver;
    LoginPage loginPage;
    DealsPage dealsPage;

    @Before
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "../Common/driver/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://freecrm.com/");
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        dealsPage = PageFactory.initElements(driver, DealsPage.class);
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

    @Given("user logs in using valid email and password")
    public void user_logs_in_using_valid_email_and_password() {
        loginPage.enterLoginData("seltmasterME@gmail.com", "freeCRM@pnt");
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLogin();
    }

    @Then("user should on the main CRM page")
    public void user_should_on_the_main_CRM_page() {
        String expectedTitle = "CRM";
        Assert.assertEquals(loginPage.getTitle(driver), expectedTitle);
    }

    @Given("user clicks on Deals")
    public void user_clicks_on_Deals() {
        loginPage.clickOnLogin();
        dealsPage.clickOnDeals();
    }

    @Given("user clicks on New button and enters new deals data")
    public void user_clicks_on_New_button_and_enters_new_deals_data() {
        dealsPage.addNewDeal();
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        dealsPage.saveNewDeal();
    }

    @Then("the new deal title should be displayed")
    public void the_new_deal_title_should_be_displayed() {
        String expectedResult = "Title1";
        System.out.println(dealsPage.getNewDealHeader(driver));
        Assert.assertEquals(dealsPage.getNewDealHeader(driver), expectedResult);
    }
}
