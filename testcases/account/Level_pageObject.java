package account;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.AMGPageObject;
import pageObjects.nopCommerce.AboutUSPageObject;
import pageObjects.nopCommerce.AudiPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageUIs.nopCommerce.HomePageUI;

import java.time.Duration;

public class Level_pageObject extends BasePage {
    private WebDriver driver;
    private  HomePageObject homePageObj;
    private AudiPageObject AudiPage;
    private AMGPageObject AMGPage;
    private AboutUSPageObject aboutUSPage;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
//        driver.get("");

        // mo 1 URL ra - no o page nao` -> khoi tao page do
        // tu` 1 page nao chuyen qua page kia -> khoi tao page do len
        homePageObj = new HomePageObject(driver);
    }

    @Test
    public void TC_01_move_to_aboutUs_page() {
        openPageURL(driver,"https://www.sytner.co.uk/");
        sleepInSeconds(2);
        clickToElement(driver,"//button[@id='onetrust-accept-btn-handler']");
//        sleepInSeconds(2);
//        scrollToBottomPageByJS(driver);
        homePageObj.clickToAboutUsLink();
//        aboutUSPage = new AboutUSPageObject();
//        aboutUSPage.clickToLogo();
    }

    @Test
    public void TC_02_openMenu(){
        homePageObj.clickToMenuButton();
        homePageObj.clickToCloseMenuButton();
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}
