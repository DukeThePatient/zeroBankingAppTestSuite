package com.zerobank.step_definitions;

import com.google.common.collect.Ordering;
import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FindTransactionsStepDefs {

    LoginPage loginPage = new LoginPage();
    AccountSummaryPage actSumPage = new AccountSummaryPage();
    AccountActivityPage actActPage = new AccountActivityPage();
    FindTransactionsPage findTSPage = new FindTransactionsPage();

    @Given("the user accesses the Find Transactions Tab")
    public void the_user_accesses_the_Find_Transactions_Tab() {
        loginPage.login();
        actSumPage.accountActivityTab.click();
        actActPage.findTransactionsTab.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        findTSPage.fromDateInput.sendKeys(fromDate);
        findTSPage.toDateInput.sendKeys(toDate);
    }

    @When("clicks find")
    public void clicks_find() {
        findTSPage.findBtn.click();

    }

    @Then("the results table should only show transactions dates between {string} to {string}")
    public void the_results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        FindTransactionsPage page = new FindTransactionsPage();

        for(String each : page.datesDisplayed()){
            page.compareDates(each, fromDate, toDate);
        }
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        FindTransactionsPage page = new FindTransactionsPage();
        boolean list = Ordering.natural().reverse().isOrdered(page.datesDisplayed());
        Assert.assertTrue(list);
    }
    @When("the user enters description {string}")
    public void the_user_enters_description(String str) {
        String string = str.toUpperCase();
        FindTransactionsPage page = new FindTransactionsPage();
        page.descriptionInput.sendKeys(string);
    }

    @Then("the results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String str) throws Exception {
        FindTransactionsPage page = new FindTransactionsPage();
        for(int i = 0; i < page.descriptionDisplayed().size(); i++){
            if(!page.descriptionDisplayed().get(i).startsWith(str)){
                throw new Exception("Wrong description type");
            }
        }
    }

}
