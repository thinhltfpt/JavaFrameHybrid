package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage   {
    // khoi tao driver
    WebDriver driver;
    public HomePageObject(WebDriver driverPageObject) {
        this.driver = driverPageObject;
    }

    // map driver

    public void clickToAboutUsLink(){
        scrollToElement(driver,HomePageUI.ABOUT_US_LINK);
        waitForElementVisible(driver,HomePageUI.ABOUT_US_LINK);
        waitForElementClickable(driver,HomePageUI.ABOUT_US_LINK);
        clickToElement(driver,HomePageUI.ABOUT_US_LINK);
    }

    public void clickToMenuButton() {
    }

    public void clickToCloseMenuButton() {
    }
}
