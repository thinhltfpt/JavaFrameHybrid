package account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.factory.CustomerPageObject;
import pageObjects.nopCommerce.AMGPageObject;
import pageObjects.nopCommerce.AboutUSPageObject;
import pageObjects.nopCommerce.AudiPageObject;
import pageObjects.nopCommerce.HomePageObject;

public class Level_selenium_page_factory extends BaseTest {
    private WebDriver driver;
    private CustomerPageObject customerPageObject;
    private String email = GetEmailRandom();
    // multi browser
    @Parameters("browser")  // denpendencies injection
    @BeforeClass
    public void beforeClass(String browser) {
      driver= getBrowserDriver(browser);
    }

    @Test
    public void TC_01_moveToMobile () {
        // click accept cookie
        customerPageObject = new CustomerPageObject(driver);
        customerPageObject.getURL();
        customerPageObject.clickToMobileLink();
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
