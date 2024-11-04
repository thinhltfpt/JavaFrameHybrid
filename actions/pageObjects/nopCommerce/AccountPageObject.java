package pageObjects.nopCommerce;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.AccountPageUI;

public class AccountPageObject extends BasePage {
    private WebDriver driver;
    public AccountPageObject (WebDriver driver){
        this.driver = driver;
    }


}
