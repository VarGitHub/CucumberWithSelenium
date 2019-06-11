package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DealsPage extends LoginPage {
    @FindBy(xpath = "//span[contains(text(),'Deals')]")
    private WebElement dealsLink;

    @FindBy(xpath = "//button[contains(text(),'New')]")
    private WebElement newDealsButton;

    @FindBy(name = "title")
    private WebElement dealsTitle;

    @FindBy(name = "commission")
    private WebElement dealsCommission;

    @FindBy(name = "next_step")
    private WebElement nextSteps;

    @FindBy(xpath = "//button[@class='ui linkedin button']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
    private WebElement newDealHeader;

    @FindBy(xpath = "//p[contains(text(),'Title1')]")
    private WebElement title1;

    public void clickOnDeals() {
        dealsLink.click();
    }

    public void addNewDeal() {
        newDealsButton.click();
        dealsTitle.sendKeys("Title1");
        dealsCommission.sendKeys("100");
        nextSteps.sendKeys("Next Steps");
    }

    public void saveNewDeal() {
        saveButton.click();
    }

    public String getNewDealHeader(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(title1));
        return newDealHeader.getText();
    }
}
