package commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.Duration;
import java.util.Random;

public class BaseTest {
    protected final Logger log;
    public BaseTest() {
        log = LogManager.getLogger(getClass());
    }

    WebDriver driver;
    WebDriverWait implicitWait;


    protected WebDriver getBrowserDriver(String browser){
        // == thi` kiem tra gia tri
        // equal thi` kiem tra vung` nho' (String dun`g)
        // equal: dung' value - dung' hoa thuong`
        // equalIgnoreCase: dung' value - ko kiem tra hoa thuong

        String os = System.getProperty("os.name").toLowerCase();
        BrowserList browserList = BrowserList.valueOf(browser.toUpperCase());
//        if (browserList.equals("FIREFOX")) {
//            driver = new FirefoxDriver();
//        } else if (browserList.equals("CHROME")) {
//            driver = new ChromeDriver();
//        } else if (browserList.equals("EDGE")) {
//            driver = new EdgeDriver();
//        } else {
//            throw new RuntimeException("Browser invalid");
//        }
        switch (browserList) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser invalid");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://live.techpanda.org/index.php/");
        return driver;
    }

    protected WebDriver getBrowserDriver(String browser,String url){
        String os = System.getProperty("os.name").toLowerCase();
        BrowserList browserList = BrowserList.valueOf(browser.toUpperCase());

        switch (browserList) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser invalid");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    protected  String GetEmailRandom(){
        Random rand = new Random();
        String email = "letienthinh" + rand.nextInt(8888) + "gmail.com";
        return "letienthinh" + new Random().nextInt(8888) + "gmail.com";
    }

    protected void closeBrowser(){
        if (driver == null){
            System.out.println("Browser is closed");
        } else {
            driver.quit();
        }
    }

    // logging
    protected boolean verifyTrue(boolean condition) {
        boolean status = true;
        try {
            Assert.assertTrue(condition);
            log.info("---------------------- Passed -----------------------");
        } catch (Throwable e) {
            status = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
            log.info("---------------------- Failed -----------------------");
        }
        return status;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean status = true;
        try {
            Assert.assertFalse(condition);
            log.info("---------------------- Passed -----------------------");
        } catch (Throwable e) {
            status = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
            log.info("---------------------- Failed -----------------------");
        }
        return status;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean status = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info("---------------------- Passed -----------------------");
        } catch (Throwable e) {
            status = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
            log.info("---------------------- Failed -----------------------");
        }
        return status;
    }

//    protected boolean verifyTrue(boolean condition) {
//        boolean pass = true;
//        try {
//            Assert.assertTrue(condition);
//        } catch (Throwable e) {
//            pass = false;
//
//            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
//            Reporter.getCurrentTestResult().setThrowable(e);
//        }
//        return pass;
//    }
//
//    protected boolean verifyFalse(boolean condition) {
//        boolean pass = true;
//        try {
//            Assert.assertFalse(condition);
//        } catch (Throwable e) {
//            pass = false;
//            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
//            Reporter.getCurrentTestResult().setThrowable(e);
//        }
//        return pass;
//    }
//
//    protected boolean verifyEquals(Object actual, Object expected) {
//        boolean pass = true;
//        try {
//            Assert.assertEquals(actual, expected);
//        } catch (Throwable e) {
//            pass = false;
//            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
//            Reporter.getCurrentTestResult().setThrowable(e);
//        }
//        return pass;
//    }



}
