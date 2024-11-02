package account;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.MobilePageObject;
import pageObjects.nopCommerce.TVPageObject;

public class HomePage extends BasePage {
    private WebDriver driver;
    private HomePageObject homePageObj;
    private MobilePageObject mobilePageObj;
    private TVPageObject tvPageObj;
    // multi browser
    @Parameters("browser")  // denpendencies injection
    @BeforeClass
    public void beforeClass(String browser) {
        // == thi` kiem tra gia tri
        // equal thi` kiem tra vung` nho' (String dun`g)
        // equal: dung' value - dung' hoa thuong`
        // equalIgnoreCase: dung' value - ko kiem tra hoa thuong
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("browser invalid");
        }


        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.sytner.co.uk/");

        // mo 1 URL ra - no o page nao` -> khoi tao page do
        // tu` 1 page nao chuyen qua page kia -> khoi tao page do len
        homePageObj = new HomePageObject(driver);
    }

    @Test
    public void TC_01_move_to_aboutUs_page() {
        sleepInSeconds(2);
        // click accept cookie
        clickToElement(driver, "//button[@id='onetrust-accept-btn-handler']");

    }

    @Test
    public void TC_02_openMenu() {
        sleepInSeconds(3);
        // click accept cookie
        clickToElement(driver, "//button[@id='onetrust-accept-btn-handler']");

    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}
