package PageOBSauce;

import PageSauceUI.LoginSuaceUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginSauce extends BasePage {
    WebDriver driver;

    public LoginSauce(WebDriver driver) {
        this.driver = driver;
    }

    public void addUserName(String userName) {
        waitForElementVisible(driver,LoginSuaceUI.USER_NAME);
        sendkeyElement(driver,LoginSuaceUI.USER_NAME,userName);
    }

    public void addPassword(String password) {
        waitForElementVisible(driver,LoginSuaceUI.PASSWORD);
        sendkeyElement(driver,LoginSuaceUI.PASSWORD,password);
    }

    public ProductSauce clickToLogin() {
        waitForElementClickable(driver, LoginSuaceUI.LOGIN_BUTTON);
        clickToElement(driver,LoginSuaceUI.LOGIN_BUTTON);
        return PageManagerSauce.getProductSauce(driver);
    }
}
