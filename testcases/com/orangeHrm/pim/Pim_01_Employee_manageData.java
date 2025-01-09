package com.orangeHrm.pim;

import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.PageGeneratorManager;
import pageObject.orangeHrm.*;

public class Pim_01_Employee_manageData extends BaseTest {
    private WebDriver driver;
    private String browser, employeeID,firstName, lastName;
    private LoginPageObject loginPO;
    private DashboardPageObject dashboardPO;
    private EmployeeListPageObject employeeListPO;
    private AddEmployeePageObject addEmployeePO;
    private PersonalDetailsPageObject personalDetailsPO;

//    private lastName, firstName;
    @Parameters({"url","browser","firstName","lastName"})
    @BeforeClass
    public void beforeClass(String url, String browser,String firstName, String lastName){
        driver = getBrowserDriver(browser,url);
        this.browser = browser;
        this.firstName = firstName;
        this.lastName = lastName;

        loginPO = PageGeneratorManager.getLoginPage(driver);

        loginPO.enterUserName(GlobalConstants.ADMIN_USER_ORANGE);
        loginPO.enterPassword(GlobalConstants.ADMIN_PASSWORD_ORANGE);
        dashboardPO = loginPO.clickToLoginButton();

        employeeListPO = dashboardPO.openPIMModule();

    }

    @Test
    public void Employee_01_Add_new(){
        log.info("step 1: demo 1");
        addEmployeePO = employeeListPO.clickToAddEmployeeButton();

        addEmployeePO.enterToFirstNameTextBox(firstName);
        addEmployeePO.enterToLastNameTextBox(lastName);
        employeeID = addEmployeePO.getEmployeeId();

        addEmployeePO.clickSaveButton();
        Assert.assertTrue(addEmployeePO.isSuccessMessageDisplayed("Successfully Saved"));
        addEmployeePO.waitForSpinnerIconInvisible();

        personalDetailsPO = PageGeneratorManager.getPersonalDetailsPage(driver);

        Assert.assertTrue(personalDetailsPO.isPersonalDetailsHeaderDisplay());
        personalDetailsPO.waitForSpinnerIconInvisible();

        Assert.assertEquals(personalDetailsPO.getFirstNameValue(),firstName);
        Assert.assertEquals(personalDetailsPO.getLastNameValue(),lastName);
        Assert.assertEquals(personalDetailsPO.getEmployeeIDValue(),employeeID);

        employeeListPO = personalDetailsPO.clickToEmployeeListButton();
        employeeListPO.enterEmployeeIDTextbox(employeeID);
        employeeListPO.clickToSearchButton();
        Assert.assertTrue(employeeListPO.isValueDisplayedAtColumnName("Id","1",employeeID));
        Assert.assertTrue(employeeListPO.isValueDisplayedAtColumnName("First (& Middle) Name","1",firstName));
        Assert.assertTrue(employeeListPO.isValueDisplayedAtColumnName("Last Name","1",lastName));

    }

    @Test
    public void Employee_02_Personal_Details(){}

    @Test
    public void Employee_03_Contact_Details(){}

    @Test
    public void Employee_04_Emergency_contacts(){}

    @Test
    public void Employee_05_Dependents(){}

    @Test
    public void Employee_06_Immigration(){}

    @Test
    public void Employee_07_Job(){}

    @Test
    public void Employee_08_Salary(){}

    @Test
    public void Employee_09_ReportTo(){}

    @Test
    public void Employee_10_Qualifications(){}

    @Test
    public void Employee_11_Memberships(){}

    @AfterClass
    public void afterClass(){
//        closeBrowser();
    }

}
