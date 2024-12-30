package pageObject.orangeHrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class JobPageObject extends BaseActions {
    private WebDriver driver;

    public JobPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
