package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBillsPage {
    public PayBillsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "sp_amount")
    public WebElement amntInput;

    @FindBy(id = "sp_date")
    public WebElement dateInput;

    @FindBy(id = "sp_description")
    public WebElement descriptionInput;

    @FindBy(id = "pay_saved_payees")
    public WebElement payBtn;

    @FindBy(id = "alert_content")
    public WebElement confirmationAlert;


}
