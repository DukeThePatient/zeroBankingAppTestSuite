package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountActivityStepDefs {

    AccountActivityPage acctActvtyPage = new AccountActivityPage();
    DashboardPage dbPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();

    @Given("the user is on the Account Activity Page")
    public void the_user_is_on_the_Account_Activity_Page() {
        //logging in
        loginPage.login();
        //clicking account activity tab
        dbPage.acctActivityTab.click();
        //assigning actual page title
        String title = Driver.get().getTitle();
        //assigning expected page title
        String expectedTitle = ConfigurationReader.get("acctActivityTitle");

        //testing the actual title against the expected title
        Assert.assertEquals(expectedTitle, title);


    }

    @Then("the title should be Zero - Account Activity")
    public void the_title_should_be_Zero_Account_Activity() {
        //assigning actual page title
        String title = Driver.get().getTitle();
        //assigning expected page title
        String expectedTitle = ConfigurationReader.get("acctActivityTitle");

        //testing the actual title against the expected title
        Assert.assertEquals(expectedTitle, title);
    }
    @Then("the default drop down menu option should be Savings")
    public void the_default_drop_down_menu_option_should_be_Savings() {
        Select menu = new Select(acctActvtyPage.dropDownMenu);
        //assigning the first menu option
        String firstOption = menu.getFirstSelectedOption().getText();
        //assigning the expected first menu option
        String expectedFirstOption = ConfigurationReader.get("acctActvtyFirstMenuOption");
        //testing the actual option against the expected option
        Assert.assertEquals(expectedFirstOption, firstOption);

    }
    @Then("the drop down menu should have the appropriate options")
    public void the_drop_down_menu_should_have_the_appropriate_options() {

        List<String> items = new ArrayList<>();
        //assigning the actual drop down menu options to a list
        Select menu = new Select(acctActvtyPage.dropDownMenu);
        for(WebElement each : menu.getOptions()){
            items.add(each.getText());
        }
        //assigning the expected options to a list
        List<String> expectedItems = new ArrayList<>(Arrays.asList(
                "Savings", "Checking", "Loan", "Credit Card", "Brokerage"
        ));
        //testing the actual list against the expected list
        Assert.assertEquals(expectedItems, items);
    }
    @Then("the transaction table should have the appropriate options")
    public void the_transaction_table_should_have_the_appropriate_options() {
        List<String> actualColumns = new ArrayList<>();
        //assigning the actual table columns to a list
        for(WebElement each : acctActvtyPage.tableColumns){
            actualColumns.add(each.getText());
        }
        //assigning the expected columns to a list
        List<String> expectedColumns = new ArrayList<>(Arrays.asList(
                "Date", "Description", "Deposit", "Withdrawal"
        ));
        //testing the actual list against the expected list
        Assert.assertEquals(expectedColumns, actualColumns);
    }
}
