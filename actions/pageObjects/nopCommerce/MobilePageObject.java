package pageObjects.nopCommerce;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.MobilePageUI;

public class MobilePageObject extends BasePage {
    WebDriver driver;
    public MobilePageObject(WebDriver driver){
        this.driver = driver;
    }

    public void getTextRoot() {
        getElementText(driver, MobilePageUI.textRoot);
    }

    public HomePageObject clickToHomePage() {
        clickToElement(driver,MobilePageUI.HomePageLink);
        return PageGeneratorManager.getHomePage(driver);
    }
}
