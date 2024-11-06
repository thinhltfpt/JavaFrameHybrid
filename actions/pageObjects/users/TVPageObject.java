package pageObjects.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class TVPageObject extends BasePage {
    WebDriver driver;
    public TVPageObject (WebDriver driver){
        this.driver = driver;
    }
}
