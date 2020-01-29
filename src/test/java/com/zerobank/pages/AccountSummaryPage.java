package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage {
    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(css = "h2[class='board-header']")
    public List<WebElement> headers;

    @FindBy(xpath = "(//table[@class='table'])[3]//th")
    public List<WebElement> creditAccountsCols;


    @FindBy(css = "a[href='/bank/account-activity.html?accountId=1']")
    public WebElement savingsLink;

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=6']")
    public WebElement brokerageLink;

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=2']")
    public WebElement checkingLink;

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=5']")
    public WebElement creditCardLink;

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=4']")
    public WebElement loanLink;

    @FindBy(css = "a[href='/bank/redirect.html?url=account-activity.html']")
    public WebElement accountActivityTab;

    public void chooseAccount(String accountType){
        AccountSummaryPage actSumPage = new AccountSummaryPage();

        if(accountType.equalsIgnoreCase("savings")){
            actSumPage.savingsLink.click();
        }else if(accountType.equalsIgnoreCase("brokerage")){
            actSumPage.brokerageLink.click();
        }else if(accountType.equalsIgnoreCase("checking")){
            actSumPage.checkingLink.click();
        }else if(accountType.equalsIgnoreCase("credit card")){
            actSumPage.creditCardLink.click();
        }else if(accountType.equalsIgnoreCase("loan")){
            actSumPage.loanLink.click();
        }else{
            System.out.println("No such account type");
        }
    }
}
