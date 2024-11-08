package pageObjectt.jQuery.upload;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUI.jQuery.upload.UploadPageUI;
import pageUIs.BasePageUI;

import java.util.List;

public class UploadPageOb extends BasePage {
    WebDriver driver;

    public UploadPageOb(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isFileLoadedSuccess(String fileName) {
        waitForElementVisible(driver, UploadPageUI.FILE_LOADED_BY_NAME,fileName);
        return isElementDisplayed(driver,UploadPageUI.FILE_LOADED_BY_NAME,fileName);
    }

    public void clickStartButtonOnEachFile() {
        List<WebElement> startButtons = getListWebElement(driver,UploadPageUI.MULTIPLE_START_BUTTON);
        for (WebElement button: startButtons){
            waitForElementClickable(driver,button);
            clickToElement(driver,button);
        }

    }

    public boolean isFileUploadedSuccess(String fileName) {
        waitForElementVisible(driver, UploadPageUI.FILE_UPLOADED_BY_NAME,fileName);
        return isElementDisplayed(driver,UploadPageUI.FILE_UPLOADED_BY_NAME,fileName);
    }
}
