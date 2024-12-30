package pageObject.orangeHrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUI.orangeHrm.AddEmployeePageUI;
import pageUI.orangeHrm.BaseActionsUI;

public class BaseActions extends BasePage {
    private WebDriver driver;

    public BaseActions(WebDriver driver){
        this.driver = driver;
    }

    public void waitForSpinnerIconInvisible() {
        waitForListElementInvisible(driver, BaseActionsUI.SPINNER_ICON);
    }

    public boolean isSuccessMessageDisplayed(String messageContent ) {
        waitForElementVisible(driver,BaseActionsUI.DYNAMIC_SUCCESS_MESSAGE,messageContent);
        return isElementDisplayed(driver,BaseActionsUI.DYNAMIC_SUCCESS_MESSAGE,messageContent);
    }

    public boolean isValueDisplayedAtColumnName(String columnName,String rowIndex, String rowValue) {
        int columnIndex =  getListElementSize(driver,BaseActionsUI.DYNAMIC_INDEX_BY_COLUMN_NAME,columnName) + 1;
        return isElementDisplayed(driver,BaseActionsUI.DYNAMIC_ROW_VALUE_BY_COLUMN_INDEX,rowIndex,String.valueOf(columnIndex),rowValue);
    }


}
