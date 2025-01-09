package pageObject.orangeHrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUI.orangeHrm.AddEmployeePageUI;
import pojoData.UserInfo;

public class AddEmployeePageObject extends BaseActions {
     WebDriver driver;

    public AddEmployeePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterToFirstNameTextBox(String firstName) {
        waitForElementVisible(driver, AddEmployeePageUI.FIRST_NAME_TEXTBOX);
        sendkeyElement(driver,AddEmployeePageUI.FIRST_NAME_TEXTBOX,firstName);
    }

    public void enterToLastNameTextBox(String lastName) {
        waitForElementVisible(driver,AddEmployeePageUI.LAST_NAME_TEXTBOX);
        sendkeyElement(driver,AddEmployeePageUI.LAST_NAME_TEXTBOX,lastName);
    }

    public String getEmployeeId() {
        waitForElementVisible(driver,AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(driver,AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX,"value");
    }

    public void clickSaveButton() {
        waitForElementClickable(driver,AddEmployeePageUI.SAVE_BUTTON);
        clickToElement(driver,AddEmployeePageUI.SAVE_BUTTON);
    }

    public void registerUser(UserInfo userInfo){
        enterToFirstNameTextBox(userInfo.getFirstName());
        enterToLastNameTextBox(userInfo.getLastName());
    }


}
