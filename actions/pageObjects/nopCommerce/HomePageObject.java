package pageObjects.nopCommerce;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.HomePageUI;
import pageUIs.nopCommerce.MobilePageUI;

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
