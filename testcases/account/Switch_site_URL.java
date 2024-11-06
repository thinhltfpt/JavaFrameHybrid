package account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.admin.AdminDashboardPO;
import pageObjects.admin.AdminLoginPO;
import pageObjects.users.AccountPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageOB;

public class Switch_site_URL extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePageObject;
    private LoginPageOB loginPageObject;
    private AdminDashboardPO adminDashboardPO;
    private AdminLoginPO adminLoginPO;
    private AccountPageObject accountPageObject;
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
        // login
        loginPageObject.sendKeyEmail();
        loginPageObject.sendKeyPass();
        //login xong la` vao trang account
//        accountPageObject = loginPageObject.clickToLoginButton();
//        accountPageObject.sleepInSeconds(2);
//        accountPageObject.acceptToAlert(driver);
        // account switch sang admin page
        loginPageObject.openPageURL(driver,"https://live.techpanda.org/index.php/");
        homePageObject = PageGeneratorManager.getHomePage(driver);
        homePageObject.searchField();
        homePageObject.openPageURL(driver,this.adminURL);
         //login
        adminLoginPO = PageGeneratorManager.getAdminLoginPage(driver);

        adminLoginPO.sendKeyToUsername("user01");
        adminLoginPO.sendKeyToPasswork("guru99com");
        adminDashboardPO = adminLoginPO.clickLogin();
        adminLoginPO.sleepInSeconds(5);



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
