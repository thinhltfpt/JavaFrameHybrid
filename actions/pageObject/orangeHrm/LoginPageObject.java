package pageObject.orangeHrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObject.PageGeneratorManager;
import pageUI.orangeHrm.LoginPageUI;

public class LoginPageObject  extends BaseActions {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterUserName(String userName) {
        waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
        sendkeyElement(driver,LoginPageUI.USERNAME_TEXTBOX,userName);
    }

    public void enterPassword(String password) {
        waitForElementVisible(driver,LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyElement(driver,LoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public DashboardPageObject clickToLoginButton() {
        waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
        waitForSpinnerIconInvisible();
        return PageGeneratorManager.getDashboardPage(driver);
    }
}
