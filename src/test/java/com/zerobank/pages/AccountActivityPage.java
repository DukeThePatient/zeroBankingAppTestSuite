package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountActivityPage {

    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "aa_accountId")
    public WebElement dropDownMenu;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//th")
    public List<WebElement> tableColumns;

}
