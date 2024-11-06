package account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.users.HomePageObject;

public class HomePageMultiBrowser extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePageObj;
    private String email = GetEmailRandom();
    // multi browser
    @Parameters("browser")  // denpendencies injection
    @BeforeClass
    public void beforeClass(String browser) {
      driver= getBrowserDriver(browser);
    }

    @Test
    public void TC_01_move_to_aboutUs_page() {
        // click accept cookie
        homePageObj = new HomePageObject(driver);

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
