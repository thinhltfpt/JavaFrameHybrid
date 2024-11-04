package account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.AccountPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.MobilePageObject;
import pageObjects.nopCommerce.TVPageObject;

public class HomePageManager extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePageObj;
    private MobilePageObject mobilePageObject;
    private TVPageObject tvPageObject;
    private AccountPageObject accountPageObject;
    private String email = GetEmailRandom();
    // multi browser
    @Parameters("browser")  // denpendencies injection
    @BeforeClass
    public void beforeClass(String browser) {
      driver= getBrowserDriver(browser);
      homePageObj =  PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void TC_01_move_Mobile() {
        // click accept cookie
//        homePageObj = new HomePageObject(driver);
        homePageObj.searchField();

        // chuyen sang page Mobile
        mobilePageObject = homePageObj.clickToMobileLink(driver);
        mobilePageObject.getTextRoot();
        homePageObj = mobilePageObject.clickToHomePage(driver);

        homePageObj.searchField();
    }

    @Test
    public void TC_02_SwitchPage() {
        // homePage -> AccountPage
        homePageObj.clickToPopupListAccount();
        accountPageObject = homePageObj.clickToAccountLink(driver);

        // AcoountPage -> MobilePage
        mobilePageObject = accountPageObject.clickToMobileLink(driver);

        // MobiPage -> HomePgae
        homePageObj = mobilePageObject.clickToHomePage(driver);

        // HomePage -> TVPage
        tvPageObject = homePageObj.clickToTVPage(driver);

    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
        closeBrowser();
    }
}
