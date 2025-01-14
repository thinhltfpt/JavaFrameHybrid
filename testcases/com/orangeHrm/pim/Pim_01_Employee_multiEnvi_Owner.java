package com.orangeHrm.pim;

import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.orangeHrm.*;
import utilities.EnvironmentConfig;
import utilities.PropertiesConfig;

public class Pim_01_Employee_multiEnvi_Owner extends BaseTest {
    private WebDriver driver;
    private String browser, employeeID,firstName, lastName;
    private LoginPageObject loginPO;
    private DashboardPageObject dashboardPO;
    private EmployeeListPageObject employeeListPO;
    private AddEmployeePageObject addEmployeePO;
    private PersonalDetailsPageObject personalDetailsPO;

    private EnvironmentConfig environmentConfig;
    @Parameters({"browser","server"})
    @BeforeClass
    public void beforeClass( String browser, String serverName){
        ConfigFactory.setProperty("server",serverName);
        environmentConfig = ConfigFactory.create(EnvironmentConfig.class);
        System.out.println(environmentConfig.appURL());
        System.out.println(environmentConfig.appUser());
        System.out.println(environmentConfig.age());
        driver = getBrowserDriver(browser, environmentConfig.appURL());
        this.browser = browser;


    }

    @Test
    public void Employee_01_Add_new(){

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
