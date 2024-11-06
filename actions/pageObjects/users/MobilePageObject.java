package pageObjects.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.users.MobilePageUI;

public class MobilePageObject extends BasePage {
    WebDriver driver;
    public MobilePageObject(WebDriver driver){
        this.driver = driver;
    }

    public void getTextRoot() {
        getElementText(driver, MobilePageUI.textRoot);
    }


}
