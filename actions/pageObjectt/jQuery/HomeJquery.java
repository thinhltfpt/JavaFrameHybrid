package pageObjectt.jQuery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUI.jQuery.HomeJqueryUI;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> getAllPageValuesbyColumnName(String columnName) {
        List<String> allValues = new ArrayList<String>();
        //b1 lay ra tat ca cac page
        List<WebElement> allPagelinks = getListWebElement(driver,HomeJqueryUI.ALL_PAGES_LINK);
        int columnIndex =  getListElementSize(driver,HomeJqueryUI.COLUMN_INDEX_BY_COLUMN_NAME,columnName) + 1;
        // b2: duyet qua tung page
        for (WebElement pageLink : allPagelinks){
            pageLink.click();
            sleepInSeconds(1);
        // b3 lay ra tat ca gia tri cua 1 cot trong cai page do -> luu thanh list/ set/ ...
            List<WebElement> allRowValues = getListWebElement(driver,HomeJqueryUI.ALL_VALUE_BY_COLUMN_INDEX, String.valueOf(columnIndex));
            for(WebElement rowValue : allRowValues){
                allValues.add(rowValue.getText());
            }
        }

        return allValues;

    }

    public void enterToTextboxByColumnNameAndRowIndex(String columnName, String rowIndex, String valueToSendkey) {
//        getListElementSize(driver,HomeJqueryUI.DYNAMIC_TEXTBOXBY_ROW_INDEX_AND_COLUMN_INDEX);
        int columnIndex =  getListElementSize(driver,HomeJqueryUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME,columnName) + 1;
//        waitForElementVisible(driver,HomeJqueryUI.DYNAMIC_TEXTBOXBY_ROW_INDEX_AND_COLUMN_INDEX,rowIndex,String.valueOf(columnIndex));
        sendkeyElement(driver,HomeJqueryUI.DYNAMIC_TEXTBOXBY_ROW_INDEX_AND_COLUMN_INDEX,valueToSendkey,rowIndex,String.valueOf(columnIndex));
    }

    public void selectDropdownByColumnNameAndRowIndex(String columnName, String rowIndex, String dropdownName) {
        int columnIndex =  getListElementSize(driver,HomeJqueryUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME,columnName) + 1;
        waitForElementClickable(driver,HomeJqueryUI.DYNAMIC_DROPDOWN_ROW_INDEX_AND_COLUMN_INDEX,rowIndex,String.valueOf(columnIndex));
        selectItemDefaultDropdown(driver,HomeJqueryUI.DYNAMIC_DROPDOWN_ROW_INDEX_AND_COLUMN_INDEX,dropdownName,rowIndex,String.valueOf(columnIndex));
    }

    public void clickToCheckboxByColumnNameAndRowIndex(String columnName, String rowIndex) {
        int columnIndex =  getListElementSize(driver,HomeJqueryUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME,columnName) + 1;
        waitForElementClickable(driver,HomeJqueryUI.DYNAMIC_CHECKBOX_ROW_INDEX_AND_COLUMN_INDEX,rowIndex,String.valueOf(columnIndex));
        checkToElement(driver,HomeJqueryUI.DYNAMIC_CHECKBOX_ROW_INDEX_AND_COLUMN_INDEX,rowIndex,String.valueOf(columnIndex));
    }
}
