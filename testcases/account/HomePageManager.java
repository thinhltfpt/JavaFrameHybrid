package account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.MobilePageObject;
import pageObjects.nopCommerce.TVPageObject;

public class HomePageManager extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePageObj;
    private MobilePageObject mobilePageObject;
    private TVPageObject tvPageObject;
    private String email = GetEmailRandom();
    // multi browser
    @Parameters("browser")  // denpendencies injection
    @BeforeClass
    public void beforeClass(String browser) {
      driver= getBrowserDriver(browser);
      homePageObj =  PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void TC_01_move_to_aboutUs_page() {
        // click accept cookie
//        homePageObj = new HomePageObject(driver);
        homePageObj.searchField();

        mobilePageObject = homePageObj.clickToMobileLink();
        mobilePageObject.getTextRoot();
        homePageObj = mobilePageObject.clickToHomePage();

        homePageObj.searchField();
    }

    @Test
    public void TC_02_openMenu() {
        // click accept cookie
//        Assert.assertEquals(homePageObj.getTextTheUltimate(), "The ultimate destination for luxury and performance cars");
//        homePageObj.clickToSearchLink();

    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
        closeBrowser();
    }
}
