package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FindTransactionsPage {

    public FindTransactionsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="aa_fromDate")
    public WebElement fromDateInput;

    @FindBy(id="aa_toDate")
    public WebElement toDateInput;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement findBtn;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td")
    public List<WebElement> tableContents;

    @FindBy(id = "aa_description")
    public WebElement descriptionInput;

    public boolean compareDates(String dateToCheck, String fromDate, String toDate){
        try{
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-mm-dd");
            java.util.Date fromD = fmt.parse(fromDate);
            java.util.Date toD = fmt.parse(toDate);
            java.util.Date actualD = fmt.parse(dateToCheck);

            if (actualD.compareTo(fromD) >= 0 && actualD.compareTo(toD) <= 0) {
                return true;
            }else{
                throw new Exception("Not within range");
            }
            }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
    public List<String> datesDisplayed(){
        FindTransactionsPage page = new FindTransactionsPage();
        List<String> contentsDisplayed = new ArrayList<>();
        for(WebElement element : page.tableContents){
            contentsDisplayed.add(element.getText());
        }
        List<String> dates = new ArrayList<>();
        for(int i = 0; i < contentsDisplayed.size(); i+=4){
            dates.add(contentsDisplayed.get(i));
        }
        return dates;
    }
    public List<String> descriptionDisplayed(){
        FindTransactionsPage page = new FindTransactionsPage();
        List<String> contentsDisplayed = new ArrayList<>();
        for(WebElement element : page.tableContents){
            contentsDisplayed.add(element.getText());
        }
        List<String> descriptions = new ArrayList<>();
        for(int i = 1; i < contentsDisplayed.size(); i+=4){
            descriptions.add(contentsDisplayed.get(i));
        }
        return descriptions;
    }

}
