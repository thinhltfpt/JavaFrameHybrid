package pageObjects.admin;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminLoginUI;

public class AdminLoginPO extends BasePage {
    WebDriver driver;
    public AdminLoginPO(WebDriver driver){
        this.driver=driver;
    }

    public void sendKeyToUsername(String user){
        getWebElement(driver,AdminLoginUI.user);
//        waitForElementInvisible(driver, AdminLoginUI.user);
        sendkeyElement(driver,AdminLoginUI.user,user);
    }
    public void sendKeyToPasswork(String pass){
        getWebElement(driver,AdminLoginUI.pass);
//        waitForElementInvisible(driver, AdminLoginUI.pass);
        sendkeyElement(driver,AdminLoginUI.pass,pass);
    }
    public AdminDashboardPO clickLogin(){
        waitForElementClickable(driver,AdminLoginUI.buttonLogin);
        clickToElement(driver,AdminLoginUI.buttonLogin);
        return PageGeneratorManager.getAdminDashboardPage(driver);
    }



}
