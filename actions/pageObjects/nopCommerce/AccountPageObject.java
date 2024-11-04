package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AccountPageObject extends BasePage {
    private WebDriver driver;
    public AccountPageObject (WebDriver driver){
        this.driver = driver;
    }
}
