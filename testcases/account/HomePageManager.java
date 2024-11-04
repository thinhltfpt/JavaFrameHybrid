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
        mobilePageObject = homePageObj.clickToMobileLink();
        mobilePageObject.getTextRoot();
        homePageObj = mobilePageObject.clickToHomePage();

        homePageObj.searchField();
    }

    @Test
    public void TC_02() {
        homePageObj.clickToPopupListAccount();
        accountPageObject = homePageObj.clickToAccountLink();


    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
        closeBrowser();
    }
}
