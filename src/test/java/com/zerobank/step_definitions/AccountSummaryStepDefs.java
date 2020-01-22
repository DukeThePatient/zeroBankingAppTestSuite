package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountSummaryStepDefs {
    LoginPage loginPage = new LoginPage();
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @Given("the user is on the Account Summary page")
    public void the_user_is_on_the_Account_Summary_page() {
        loginPage.login();

        //assigning the actual account summary page title
        String acctSumPageTitle = Driver.get().getTitle();
        //testing the actual page title against the expected page title
        Assert.assertEquals("Zero - Account Summary", acctSumPageTitle);

    }

    @Then("the title should be Zero - Account Summary")
    public void the_title_should_be_Zero_Account_Summary() {
        //assigning the actual account summary page title
        String acctSumPageTitle = Driver.get().getTitle();
        //testing the actual page title against the expected page title
        Assert.assertEquals("Zero - Account Summary", acctSumPageTitle);
    }

    @Then("the Account Summary page should display the correct account types")
    public void the_Account_Summary_page_should_display_the_correct_account_types() {
        //assigning the actual accounts to a list
        List<String> accounts = new ArrayList<>();
        for(WebElement each : accountSummaryPage.headers){
            accounts.add(each.getText());
        }
        //creating the expected list of accounts
        List<String> expectedAccounts = new ArrayList<>();
        expectedAccounts.addAll(Arrays.asList(
                "Cash Accounts", "Investment Accounts", "Credit Accounts", "Loan Accounts"
        ));
        //testing the actual list against the expected list
        Assert.assertEquals(expectedAccounts, accounts);
    }
    @Then("the Credit Accounts table should display the correct account columns")
    public void the_Credit_Accounts_table_should_display_the_correct_account_columns() {
        //assigning the actual columns to a list
        List<String> columns = new ArrayList<>();
        for(WebElement each: accountSummaryPage.creditAccountsCols){
            columns.add(each.getText());
        }
        //creating the expected list of columns
        List<String> expectedColumns = new ArrayList<>();
        expectedColumns.addAll(Arrays.asList(
                "Account", "Credit Card", "Balance"
        ));
        //testing the actual list against the expected list
        Assert.assertEquals(expectedColumns, columns);

    }
}
