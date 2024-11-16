package share.cookies.closeBrowser;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.users.*;

import java.util.Set;

public class LoginPage extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePageObject;
    private LoginPageOB loginPageObject;
    private MyDashboardPO myDashboardPO;
    private String userURL, adminURL;

    public static String email = "letienthinh0808@gmail.com" , pass = "123456";
    public static Set <Cookie> cookies;
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
    public void TC_01_Login() {
        // cach 1
        loginPageObject.sendKeyEmailandPass(email,"email");
        loginPageObject.sendKeyEmailandPass(pass,"pass");
        myDashboardPO = loginPageObject.clickToLoginButton();
        myDashboardPO.sleepInSeconds(3);
        myDashboardPO.acceptToAlert(driver);
        myDashboardPO.sleepInSeconds(10);
        cookies = myDashboardPO.getBrowserCookies(driver);
    }


    public void TC_02_SwitchPage() {
    }



    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //driver.quit();
        closeBrowser();
    }
}
