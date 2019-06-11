package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;
import pageobjects.LoginPage;
import pojo.LoginData;
import runner.FBRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoginSteps extends FBRunner {

    LoginPage loginPage = new LoginPage(driver);
    LoginData loginData = new LoginData();
    List<LoginData> pojoData = new ArrayList<LoginData>();

    @Given("user navigates to the login page")
    public void userNavigatesToTheLoginPage() throws Exception {
        this.loginPage.navigateToLoginPage();
        Thread.sleep(1500);
    }

    @And("user enters an invalid email and an invalid password")
    public void userEntersAnInvalidEmailAndAnInvalidPassword(DataTable table) throws Exception {

        List<Map<String, String>> credentials = table.asMaps(String.class, String.class);
        //for (Map<String, String> credentials : table.asMaps(String.class, String.class));
        /*List<List<String>> data = table.asLists();
        int i = 0;
        String[][] dataList = new String[data.size()][];
        for (List<String> list : data) {
            loginData.setUserName(list.get(0));
            loginData.setPassword(list.get(1));
            pojoData.add(new LoginData(loginData.getUserName(), loginData.getPassword()));
        }

        for (LoginData l : pojoData) {
            System.out.println(l.getUserName() + " " + l.getPassword());
         }*/
        System.out.println(credentials.size());
        for (int i = 0; i< credentials.size(); i++) {
            //System.out.println(credentials.get(0).get("emailId"));
            //System.out.println(credentials.get(0).get("password"));
            this.loginPage.enterInEmail(credentials.get(i).get("emailId"));
            Thread.sleep(1000);
            this.loginPage.enterInPassword(credentials.get(i).get("password"));
            Thread.sleep(1000);
        }
     }

//    @And("user enters an invalid \"(.*)\" and an invalid \"(.*)\"")
//    public void userEntersAnInvalidEmailAndAnInvalidPassword(String email, String pass) throws Exception {
//        this.loginPage.enterInEmail(email);
//        Thread.sleep(1000);
//        this.loginPage.enterInPassword(pass);
//        Thread.sleep(1000);
//    }

    @When("user clicks on login button")
    public void userClicksOnLoginButton() throws Exception {
        this.loginPage.login();
        Thread.sleep(1000);
    }

    @Then("user should see an error message")
    public void userShouldSeeAnErrorMessage() throws Exception {
        Assert.assertEquals(true, this.loginPage.alertMessageIsDisplayed());
        Thread.sleep(1000);
    }
}
