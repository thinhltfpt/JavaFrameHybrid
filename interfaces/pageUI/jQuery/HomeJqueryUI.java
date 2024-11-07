package pageUI.jQuery;

public class HomeJqueryUI {

    public static final String COLUMN_TEXTBOX_BY_NAME = "xpath=//div[text()='%s']/../following-sibling::input";
    public static final String PAGING = "xpath=//a[text()='%s']/..";
    public static final String DATA_TABLE_VALUES = "xpath=//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']";
    public static final String ROW_ACTION_BY_COUNTRY_NAME = "xpath=//td[@data-key='country' and text()='%s']/..//button[contains(@class,'%s')]";


}
