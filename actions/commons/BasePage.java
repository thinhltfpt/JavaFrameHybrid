package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BasePage {
    // biến toàn cục, phạm vi class
    WebDriver driver;

    // hàm để dùng làm gì
    // dùng hàm nào của selenium
    // kiểu trả về của hàm đó
    // các hàm mà tương tác thì hầu như void: click/ sendkeys/ accept/ cancel/ select/ ...
    // các hàm lấy dữ liệu:
    // 5 quy tắc trog doc

    /* Web browser */
    public void openPageURL(WebDriver driver, String pageURL) {
        // biến cục bộ
        driver.get(pageURL);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentPageURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSourceCode(WebDriver driver) {
        return driver.getPageSource();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refeshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    // alert
    public Alert waitForAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptToAlert(WebDriver driver) {
        waitForAlertPresence(driver).accept();
    }

    public void cancelToAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    public String getTextInAlert(WebDriver driver) {
        return waitForAlertPresence(driver).getText();
    }

    public void sendkeyToAlert(WebDriver driver, String keysToSend) {
        waitForAlertPresence(driver).sendKeys(keysToSend);
    }

    // windows
    // dung` cho case duy nhat 2 tab/window
    public void switchToWindowByID(WebDriver driver, String parentID) {
        // lay ra tac ca ID cua tab/window
        Set<String> allWindows = driver.getWindowHandles();
        // dung` vong lap de duyet qua tung item trong set (allIDs)
        for (String runWindow : allWindows) {
            // trong qua trinh` duyet tung item
            // neu item nao` khac' vs parentID truyen vao`
            if (!runWindow.equals(parentID)) {
                // thi` switch vao tab/ window do'
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    // dung` cho 2 tab/ window tro len
    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            // switch vao tung ids
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            // neu dung' vs title truyen vao thi switch vao tab/ window do' - thoat khoi vong lap
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    public void sleepInSeconds(long timeSecond) {
        try {
            Thread.sleep(timeSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}
