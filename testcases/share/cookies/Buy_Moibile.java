package share.cookies;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageOB;
import pageObjects.users.MobilePageObject;
import pageObjects.users.MyDashboardPO;

public class Buy_Moibile extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePageObject;
    private MobilePageObject mobilePageObject;
    private LoginPageOB loginPageObject;
    private MyDashboardPO myDashboardPO;
    private String userURL, adminURL;

    // multi browser
    @Parameters({"browser", "userURL", "adminURL"})  // denpendencies injection
    @BeforeClass
    public void beforeTest(String browser, String userURL, String adminURL) {

        this.userURL = userURL;
        this.adminURL = adminURL;

      driver= getBrowserDriver(browser,this.userURL);
      loginPageObject =  PageGeneratorManager.getLoginPage(driver);
        loginPageObject.setCookies(driver,LoginPage.cookies);
        loginPageObject.sleepInSeconds(5);
        loginPageObject.refeshCurrentPage(driver);
        myDashboardPO = PageGeneratorManager.getMyDashboardPage(driver);
        mobilePageObject = myDashboardPO.clickToMobileLink(driver);

    }

    @Test
    public void TC_01_click_to_buy_moible() {

    }

    @Test
    public void TC_02_SwitchPage() {
    }



    @AfterClass
    public void afterTest() {
        //driver.quit();
        closeBrowser();
    }
}
