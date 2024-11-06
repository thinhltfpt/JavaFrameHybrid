package pageObjects.users;

import org.openqa.selenium.WebDriver;

public class MyInforPO extends SideBarPO {
    WebDriver driver;
    public MyInforPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
