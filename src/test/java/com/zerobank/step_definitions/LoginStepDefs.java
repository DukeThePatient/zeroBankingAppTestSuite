package com.zerobank.step_definitions;

import com.zerobank.pages.HomePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {

        //assigning actual home page title
        String homePageTitle = Driver.get().getTitle();
        //testing the actual page title against the expected page title
        Assert.assertEquals("Zero - Personal Banking - Loans - Credit Cards", homePageTitle);

        homePage.signInBtn.click();

        //assigning actual login page title
        String loginPageTitle = Driver.get().getTitle();
        //testing the actual page title against the expected page title
        Assert.assertEquals("Zero - Log in", loginPageTitle);

    }

    @When("The user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        //entering the credentials
        loginPage.usernameInput.sendKeys(username);
        loginPage.userPasswordInput.sendKeys(password);
        //clicking submit
        loginPage.submitBtn.click();

    }

    @Then("The user should be able to log in")
    public void the_user_should_be_able_to_log_in() {
        //assigning the actual account page title
        String pageTitle = Driver.get().getTitle();
        //testing the actual page title against the expected page title
        Assert.assertEquals("Zero - Account Summary", pageTitle);
    }

    @When("the user enters invalid credentials")
    public void the_user_enters_invalid_credentials() {
        String username = "wrongUser";
        String password = "passwordpassword";

        //entering invalid credentials
        loginPage.usernameInput.sendKeys(username);
        loginPage.userPasswordInput.sendKeys(password);
        //clicking submit button
        loginPage.submitBtn.click();
    }

    @Then("the user should get an error message")
    public void the_user_should_get_an_error_message() {
        //asserting that the error message is displayed
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }
    @When("the user enters no credentials")
    public void the_user_enters_no_credentials() {
        String username = "";
        String password = "";

        //entering empty credentials
        loginPage.usernameInput.sendKeys(username);
        loginPage.userPasswordInput.sendKeys(password);
        //clicking submit button
        loginPage.submitBtn.click();
    }
}