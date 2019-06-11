package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(xpath = "//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left'] ")
    private WebElement loginBtnMainPage;

    @FindBy(name = "email")
    private WebElement emailAddress;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
    private WebElement loginButton;

    public void enterLoginData(String email, String pwd) {
        loginBtnMainPage.click();
        emailAddress.sendKeys(email);
        password.sendKeys(pwd);
    }

    public void clickOnLogin() {
        loginButton.click();
    }

    public String getTitle(WebDriver driver) {
        return driver.getTitle();
    }
}
