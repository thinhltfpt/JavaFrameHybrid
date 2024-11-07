package pageObjectt.jQuery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUI.jQuery.HomeJqueryUI;

public class HomeJquery extends BasePage {
    WebDriver driver;
    public HomeJquery (WebDriver driver){
        this.driver = driver;
    }

    public void inputToColumn(String valueToSend,String columnName){
        waitForElementVisible(driver, HomeJqueryUI.COLUMN_TEXTBOX_BY_NAME,columnName);
        sendkeyElement(driver,HomeJqueryUI.COLUMN_TEXTBOX_BY_NAME,valueToSend,columnName);
    }

    public void clickPaging(String pageNumber ){
        waitForElementClickable(driver,HomeJqueryUI.PAGING,pageNumber);
        clickToElement(driver,HomeJqueryUI.PAGING,pageNumber);
    }

    public String getAttributePage(String pageNumber){
        waitForElementClickable(driver,HomeJqueryUI.PAGING,pageNumber);
        return getElementAttribute(driver,HomeJqueryUI.PAGING,"class",pageNumber);
    }

    public Boolean isPageNumberDisplayed(String pageNumber){
        waitForElementClickable(driver,HomeJqueryUI.PAGING,pageNumber);
        return isElementDisplayed(driver,HomeJqueryUI.PAGING,pageNumber);
    }

    public Boolean isRowDisplayed(String female, String country){
        waitForElementVisible(driver,HomeJqueryUI.DATA_TABLE_VALUES,female,country);
        return isElementDisplayed(driver,HomeJqueryUI.DATA_TABLE_VALUES,female,country);
    }

    public void clickToRowAction(String country, String rowAction){
        waitForElementClickable(driver,HomeJqueryUI.ROW_ACTION_BY_COUNTRY_NAME,country,rowAction);
        clickToElement(driver,HomeJqueryUI.ROW_ACTION_BY_COUNTRY_NAME,country,rowAction);
    }

}
