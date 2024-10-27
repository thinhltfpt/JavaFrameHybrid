package webdriver;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Level_BasePage_static {
    private WebDriver driver;
    // ẩn giấu việc khởi tạo new khi khởi tạo hàm static ở BasePage - singleton pattern
    private BasePage basePage = BasePage.getBasePage();


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
