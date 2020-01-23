package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityNavigationStepDefs {
    LoginPage loginPage = new LoginPage();
    AccountSummaryPage actSumPage = new AccountSummaryPage();
    AccountActivityPage actActPage = new AccountActivityPage();

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        //logging in
        loginPage.login();
    }

    @When("the user clicks on the Savings link on the Account Summary page")
    public void the_user_clicks_on_the_Savings_link_on_the_Account_Summary_page() {
        actSumPage.chooseAccount("savings");
    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        //assigning the actual account summary page title
        String acctSumPageTitle = Driver.get().getTitle();
        //assigning the expected account summary page title
        String expectedTitle = ConfigurationReader.get("acctActivityTitle");
        //testing the actual page title against the expected page title
        Assert.assertEquals(expectedTitle, acctSumPageTitle);
    }

    @Then("the Account drop down should have Savings selected")
    public void the_Account_drop_down_should_have_Savings_selected() {
        List<String> items = new ArrayList<>();
        //assigning the actual drop down menu options to a list
        Select menu = new Select(actActPage.dropDownMenu);
        for(WebElement each : menu.getOptions()){
            items.add(each.getText());
        }
        //assigning the expected first option
        String expectedFirstOption = "Savings";
        //assigning the actual first option
        String actualFirstOption = items.get(0);
        //testing the actual first option against the expected
        Assert.assertEquals(expectedFirstOption, actualFirstOption);
    }

    @When("the user clicks on the Brokerage link on the Account Summary page")
    public void the_user_clicks_on_the_Brokerage_link_on_the_Account_Summary_page() {
        actSumPage.chooseAccount("brokerage");
        BrowserUtils.waitFor(3);
    }

    @Then("the Account drop down should have Brokerage selected")
    public void the_Account_drop_down_should_have_Brokerage_selected() {
        //creating the select object
        Select select = new Select(actActPage.dropDownMenu);
        //assigning the actual displayed option
        String actualFirstOption = select.getFirstSelectedOption().getText();
        //assigning the expected option
        String expectedFirstOption = "Brokerage";
        //testing the actual option agianst the expected option
        Assert.assertEquals(expectedFirstOption, actualFirstOption);
    }

    @When("the user clicks on the Checking link on the Account Summary page")
    public void the_user_clicks_on_the_Checking_link_on_the_Account_Summary_page() {
        actSumPage.chooseAccount("checking");
    }

    @Then("the account Drop down should have Checking selected")
    public void the_account_Drop_down_should_have_Checking_selected() {
        //creating the select object
        Select select = new Select(actActPage.dropDownMenu);
        //assigning the actual displayed option
        String actualFirstOption = select.getFirstSelectedOption().getText();
        //assigning the expected option
        String expectedFirstOption = "Checking";
        //testing the actual option agianst the expected option
        Assert.assertEquals(expectedFirstOption, actualFirstOption);
    }

    @When("the user clicks on the Credit Card link on the Account Summary page")
    public void the_user_clicks_on_the_Credit_Card_link_on_the_Account_Summary_page() {
        actSumPage.chooseAccount("credit card");
    }

    @Then("the Account drop down should have Credit Card selected")
    public void the_Account_drop_down_should_have_Credit_Card_selected() {
        //creating the select object
        Select select = new Select(actActPage.dropDownMenu);
        //assigning the actual displayed option
        String actualFirstOption = select.getFirstSelectedOption().getText();
        //assigning the expected option
        String expectedFirstOption = "Credit Card";
        //testing the actual option agianst the expected option
        Assert.assertEquals(expectedFirstOption, actualFirstOption);
    }

    @When("the user clicks on the Loan link on the Account Summary page")
    public void the_user_clicks_on_the_Loan_link_on_the_Account_Summary_page() {
        actSumPage.chooseAccount("loan");
    }

    @Then("the Account drop down should have Loan selected")
    public void the_Account_drop_down_should_have_Loan_selected() {
        //creating the select object
        Select select = new Select(actActPage.dropDownMenu);
        //assigning the actual displayed option
        String actualFirstOption = select.getFirstSelectedOption().getText();
        //assigning the expected option
        String expectedFirstOption = "Loan";
        //testing the actual option agianst the expected option
        Assert.assertEquals(expectedFirstOption, actualFirstOption);
    }
}
