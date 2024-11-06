package pageObjects.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class MyDashboardPO extends SideBarPO {
    WebDriver driver;
    public MyDashboardPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
