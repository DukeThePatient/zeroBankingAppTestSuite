package com.zerobank.step_definitions;

import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PayBillsStepDefs {

    LoginPage loginPage = new LoginPage();
    DashboardPage dbPage = new DashboardPage();
    PayBillsPage pbPage = new PayBillsPage();

    @Given("the user is on the Pay Bills page")
    public void the_user_is_on_the_Pay_Bills_page() {
        //logging in
        loginPage.login();
        //clicking on the pay bills tab
        dbPage.payBillsTab.click();

        //assigning the actual page title
        String actualTitle = Driver.get().getTitle();
        //assigning the expected page title
        String expectedTitle = ConfigurationReader.get("payBillsPageTitle");
        //testing the actual title against the expected title
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("the page title should be Zero - Pay Bills")
    public void the_page_title_should_be_Zero_Pay_Bills() {
        //assigning the actual page title
        String actualTitle = Driver.get().getTitle();
        //assigning the expected page title
        String expectedTitle = ConfigurationReader.get("payBillsPageTitle");
        //testing the actual title against the expected title
        Assert.assertEquals(expectedTitle, actualTitle);
    }
    @When("the user completes a successful pay operation")
    public void the_user_completes_a_successful_pay_operation() {
        //assigning the money amount
        String moneyAmnt = "1.00";
        //assigning a date
        String date = "2020-01-09";
        //sending info
        pbPage.amntInput.sendKeys(moneyAmnt);
        pbPage.dateInput.sendKeys(date);
        //clicking pay button
        pbPage.payBtn.click();


    }

    @Then("the page should display the correct confirmation message")
    public void the_page_should_display_the_correct_confirmation_message() {
        //confirming the successful pay was submitted
        Assert.assertTrue(pbPage.confirmationAlert.isDisplayed());
    }

    @When("the user does not enter an amount into the Amount field")
    public void the_user_does_not_enter_an_amount_into_the_Amount_field() {
        //assigning the money amount
        String moneyAmnt = "test";
        //assigning a date
        String date = "2020-01-09";
        //sending info
        pbPage.amntInput.sendKeys(moneyAmnt);
        pbPage.dateInput.sendKeys(date);
        //clicking pay button
        pbPage.payBtn.click();

    }
    @When("the user does not enter a date into the Date field")
    public void the_user_does_not_enter_a_date_into_the_Date_field() {
        //assigning the money amount
        String moneyAmnt = "1.00";
        //assigning a date
        String date = "test";
        //sending info
        pbPage.amntInput.sendKeys(moneyAmnt);
        pbPage.dateInput.sendKeys(date);
        //clicking pay button
        pbPage.payBtn.click();
    }

    @Then("the page should display the correct error message for the Amount field")
    public void the_page_should_display_the_correct_error_message() {
        //assigning the actual error message
        String errorMessage = pbPage.amntInput.getAttribute("validationMessage");
        //assigning the expected error message
        String expectedMessage = "Please fill out this field.";

        //testing the actual message against the expected
        Assert.assertEquals(expectedMessage, errorMessage);
    }
    @Then("the page should display the correct error message for the Date field")
    public void the_page_should_display_the_correct_error_message_for_the_Date_field() {
        //assigning the actual error message
        String errorMessage = pbPage.dateInput.getAttribute("validationMessage");
        //assigning the expected error message
        String expectedMessage = "Please fill out this field.";

        //testing the actual message against the expected
        Assert.assertEquals(expectedMessage, errorMessage);
    }
    @When("the user enters alphabetical into the Amount field")
    public void the_user_enters_alphabetical_into_the_Amount_field() {
        //assigning the money amount
        String moneyAmnt = "ABC";
        //assigning a date
        String date = "2020-01-09";
        //sending info
        pbPage.amntInput.sendKeys(moneyAmnt);
        pbPage.dateInput.sendKeys(date);
        //clicking pay button
        pbPage.payBtn.click();
    }

    @When("the user enters special characters into the Amount field")
    public void the_user_enters_special_characters_into_the_Amount_field() {
        //assigning the money amount
        String moneyAmnt = "@#$";
        //assigning a date
        String date = "2020-01-09";
        //sending info
        pbPage.amntInput.sendKeys(moneyAmnt);
        pbPage.dateInput.sendKeys(date);
        //clicking pay button
        pbPage.payBtn.click();
    }

    @When("the user enters alphabetical into the Date field")
    public void the_user_enters_alphabetical_into_the_Date_field() {
        //assigning the money amount
        String moneyAmnt = "1.00";
        //assigning a date
        String date = "AS-FE-ASFD";
        //sending info
        pbPage.amntInput.sendKeys(moneyAmnt);
        pbPage.dateInput.sendKeys(date);
        //clicking pay button
        pbPage.payBtn.click();

    }

}
