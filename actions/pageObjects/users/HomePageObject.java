package pageObjects.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.users.HomePageUI;

public class HomePageObject extends BasePage   {
    // khoi tao driver
    private WebDriver driver;
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    // map driver


    public void searchField(){
        sendkeyElement(driver,HomePageUI.searchField,"hello");
    }

    public String getTextSearchField(){
        return getElementText(driver,HomePageUI.searchField);
    }

    public void clickToPopupListAccount(){
        clickToElement(driver,HomePageUI.popUpAccount);
    }



}
