package pageUI.jQuery.table;

public class HomeJqueryUI {

    public static final String COLUMN_TEXTBOX_BY_NAME = "xpath=//div[text()='%s']/../following-sibling::input";
    public static final String PAGING = "xpath=//a[text()='%s']/..";
    public static final String DATA_TABLE_VALUES = "xpath=//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']";
    public static final String ROW_ACTION_BY_COUNTRY_NAME = "xpath=//td[@data-key='country' and text()='%s']/..//button[contains(@class,'%s')]";
    public static final String ALL_PAGES_LINK = "xpath=//a[contains(@class,'qgrd-pagination-page')]";

    public static final String COLUMN_INDEX_BY_COLUMN_NAME = "xpath=//div[text()='%s']/ancestor::th/preceding-sibling::th";
    public static final String ALL_VALUE_BY_COLUMN_INDEX = "xpath=//tr//td[%s]";

    public static final String DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME = "xpath=//th[text()='%s']/preceding-sibling::th";
    public static final String DYNAMIC_TEXTBOXBY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tr[%s]//td[%s]/input";
    public static final String DYNAMIC_DROPDOWN_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]//select";
    public static final String DYNAMIC_CHECKBOX_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]//input[@type='checkbox']";


}
