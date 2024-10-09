package account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Account_register {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public void sleepInSeconds (long timeSecond){
        try {
            Thread.sleep(timeSecond*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void Register_01_EmptyData() {
    }

    @Test
    public void Register_02_Invalid_Email() {
    }

    @Test
    public void Register_03_Invalid_Pass() {
    }

    @Test
    public void Register_04_Incorrect_Confirm_Pass() {
    }

    @Test
    public void Register_05_Success() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
