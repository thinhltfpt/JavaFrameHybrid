package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageFactory {

    protected static BasePageFactory getFactory(){return new BasePageFactory();}

    protected void openPageURL(WebDriver driver, String  pageURL) {
        // biến cục bộ
        driver.get(pageURL);
    }

    protected String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    protected String getCurrentPageURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    protected String getPageSourceCode(WebDriver driver) {
        return driver.getPageSource();
    }

    protected void forwardToPage(WebDriver driver) {
        driver.navigate().back();
    }

    protected void backToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    protected void refeshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    // alert
    protected Alert waitForAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
    }

    protected void acceptToAlert(WebDriver driver) {
        waitForAlertPresence(driver).accept();
    }

    protected void cancelToAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    protected String getTextInAlert(WebDriver driver) {
        return waitForAlertPresence(driver).getText();
    }

    protected void clickToElement(WebDriver driver, WebElement element){
        element.click();
    }

    protected void senkeyToElement(WebDriver driver, WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    protected String getTextElement(WebDriver driver,WebElement element){
        return element.getText();
    }

    protected void waitForElementVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
    }






}
