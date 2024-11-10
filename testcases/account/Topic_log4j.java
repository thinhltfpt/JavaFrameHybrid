package account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.users.*;

public class Topic_log4j extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePageObject;
    private LoginPageOB loginPageObject;
    private MyDashboardPO myDashboardPO;
    private SideBarPO myInforUI;
    private MyAdressBookOP myAdressBookOP;
    private SideBarPO sideBarPO;
    private String userURL, adminURL;

    private String email = "letienthinh0808@gmail.com", pass = "123456" ;
    // multi browser
    @Parameters({"browser", "userURL", "adminURL"})  // denpendencies injection
    @BeforeClass
    public void beforeClass(String browser, String userURL, String adminURL) {

        this.userURL = userURL;
        this.adminURL = adminURL;

      driver= getBrowserDriver(browser,this.userURL);
      loginPageObject =  PageGeneratorManager.getLoginPage(driver);
    }

    @Test
    public void TC_01_userSite_to_adminSite() {
        // cach 1
        log.info("TC_01_userSite - Step 1: add email " + email);
        loginPageObject.sendKeyEmailandPass(this.email,"email");
        log.info("TC_01_userSite - Step 2: add pass " + pass);
        loginPageObject.sendKeyEmailandPass(this.pass,"pass");
        myDashboardPO = loginPageObject.clickToLoginButton();
        myDashboardPO.sleepInSeconds(3);
        myDashboardPO.acceptToAlert(driver);
        myDashboardPO.sleepInSeconds(3);
//        myInforUI = myDashboardPO.openSideBarPages("Account Information");
//        myAdressBookOP = (MyAdressBookOP) myInforUI.openSideBarPages("Address Book");
//        myInforUI = myAdressBookOP.openSideBarPages("Account Information");

        // cach 2
        myDashboardPO.openSideBarPage("Account Information");
        myInforUI = PageGeneratorManager.getMyInforPage(driver);
        myInforUI.openSideBarPage("Address Book");
        myAdressBookOP = PageGeneratorManager.getMyAdressBookPage(driver);

    }

    @Test
    public void TC_02_SwitchPage() {
    }



    @AfterClass
    public void afterClass() {
        //driver.quit();
        closeBrowser();
    }
}
