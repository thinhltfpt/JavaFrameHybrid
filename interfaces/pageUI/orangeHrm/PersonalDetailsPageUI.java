package pageUI.orangeHrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class PersonalDetailsPageUI {
    public static final String FIRSTNAME_TEXTBOX = "css=input[name='firstName']";
    public static final String LASTNAME_TEXTBOX = "css=input[name='lastName']";
    public static final String EMPLOYEE_ID_TEXTBOX = "xpath=//label[text()='Employee Id']/../following-sibling::div/input";
    public static final String EMPLOYEE_LIST_BUTTON = "xpath=//a[text()='Employee List']";
    public static final String PERSONAL_DETAILS_HEADER = "xpath=//h6[text()='Personal Details']";

}
