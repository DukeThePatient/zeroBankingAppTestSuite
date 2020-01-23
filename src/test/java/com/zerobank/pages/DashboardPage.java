package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    public DashboardPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "a[href='/bank/redirect.html?url=account-activity.html']")
    public WebElement acctActivityTab;

    @FindBy(css = "a[href='/bank/redirect.html?url=pay-bills.html']")
    public WebElement payBillsTab;

}
