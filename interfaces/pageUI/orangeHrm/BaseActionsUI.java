package pageUI.orangeHrm;

public class BaseActionsUI {
    public static final String SPINNER_ICON = "css=div.oxd-loading-spinner-container";
    public static final String DYNAMIC_SUCCESS_MESSAGE = "xpath=//p[contains(@class,'oxd-toast-content-text') and text()='%s']";
    public static final String DYNAMIC_INDEX_BY_COLUMN_NAME = "xpath=//div[text()='%s']/preceding-sibling::div";
    public static final String DYNAMIC_ROW_VALUE_BY_COLUMN_INDEX = "xpath=//div[@class='oxd-table-card']//div[@role='row'][%s]/div[%s]/div[contains(text(),'%s')]";
}
