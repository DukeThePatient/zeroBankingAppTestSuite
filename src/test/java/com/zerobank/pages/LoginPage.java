package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "user_login")
    public WebElement usernameInput;

    @FindBy(id = "user_password")
    public WebElement userPasswordInput;

    @FindBy(name = "submit")
    public WebElement submitBtn;

    @FindBy(css = "div[class='alert alert-error']")
    public WebElement errorMessage;

    public void login(){
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        //clicking sign in button
        homePage.signInBtn.click();

        //entering credentials and submitting
        loginPage.usernameInput.sendKeys(username);
        loginPage.userPasswordInput.sendKeys(password);
        loginPage.submitBtn.click();

    }

}
