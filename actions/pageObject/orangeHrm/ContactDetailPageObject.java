package pageObject.orangeHrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ContactDetailPageObject extends BaseActions {
    private WebDriver driver;

    public ContactDetailPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
