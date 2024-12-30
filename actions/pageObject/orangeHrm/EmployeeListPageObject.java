package pageObject.orangeHrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObject.PageGeneratorManager;
import pageUI.orangeHrm.EmployeeListPageUI;

public class EmployeeListPageObject extends BaseActions {
    private WebDriver driver;

    public EmployeeListPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public AddEmployeePageObject clickToAddEmployeeButton() {
        waitForElementClickable(driver, EmployeeListPageUI.ADD_EMPLOYEE_BUTTON);
        clickToElement(driver,EmployeeListPageUI.ADD_EMPLOYEE_BUTTON);
        waitForSpinnerIconInvisible();
        return PageGeneratorManager.getEmployeePage(driver);
    }

    public void enterEmployeeIDTextbox(String employeeID) {
        waitForElementVisible(driver,EmployeeListPageUI.EMPLOYEE_ID_TEXTBOX);
        sendkeyElement(driver,EmployeeListPageUI.EMPLOYEE_ID_TEXTBOX,employeeID);
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver,EmployeeListPageUI.SEARCH_BUTTON);
        clickToElement(driver,EmployeeListPageUI.SEARCH_BUTTON);
        waitForSpinnerIconInvisible();
    }


}
