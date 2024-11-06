package pageObjects.users;

import org.openqa.selenium.WebDriver;

public class MyAdressBookOP extends SideBarPO{
    WebDriver driver;
    public MyAdressBookOP(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
