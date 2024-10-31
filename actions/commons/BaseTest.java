package commons;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class BaseTest {
    WebDriver driver;
    WebDriverWait implicitWait;
    protected WebDriver getBrowserDriver(String browser){
        // == thi` kiem tra gia tri
        // equal thi` kiem tra vung` nho' (String dun`g)
        // equal: dung' value - dung' hoa thuong`
        // equalIgnoreCase: dung' value - ko kiem tra hoa thuong

        String os = System.getProperty("os.name").toLowerCase();
        BrowserList browserList = BrowserList.valueOf(browser.toUpperCase());
//        if (browserList == BrowserList.FIREFOX) {
//            driver = new FirefoxDriver();
//        } else if (browserList == BrowserList.CHROME) {
//            driver = new ChromeDriver();
//        } else if (browserList == BrowserList.EDGE) {
//            driver = new EdgeDriver();
//        } else {
//            throw new RuntimeException("browser invalid");
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
        driver.get("https://www.sytner.co.uk/");
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


}
