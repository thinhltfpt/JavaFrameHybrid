package pageObjects.users;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.users.LoginPageUI;

public class LoginPageOB extends BasePage   {
    // khoi tao driver
    private WebDriver driver;
    public LoginPageOB(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeyEmail(){
        waitForElementVisible(driver, LoginPageUI.email);
        sendkeyElement(driver, LoginPageUI.email,"letienthinh0808@gmail.com");
    }
    public void sendKeyPass(){
        waitForElementVisible(driver, LoginPageUI.pass);
        sendkeyElement(driver, LoginPageUI.pass,"123456");
    }
    public MyDashboardPO clickToLoginButton(){
        waitForElementClickable(driver, LoginPageUI.loginButton);
        clickToElement(driver, LoginPageUI.loginButton);
        return PageGeneratorManager.getMyDashboardPage(driver);
    }

    public void sendKeyEmailandPass(String value, String restParameter){
        waitForElementVisible(driver,LoginPageUI.dynamic_pass_email,restParameter);
        sendkeyElement(driver,LoginPageUI.dynamic_pass_email,value,restParameter);
    }



}
