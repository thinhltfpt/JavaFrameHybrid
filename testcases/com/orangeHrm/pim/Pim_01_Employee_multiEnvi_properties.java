package com.orangeHrm.pim;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.orangeHrm.*;
import utilities.PropertiesConfig;

public class Pim_01_Employee_multiEnvi_properties extends BaseTest {
    private WebDriver driver;
    private String browser, employeeID,firstName, lastName;
    private LoginPageObject loginPO;
    private DashboardPageObject dashboardPO;
    private EmployeeListPageObject employeeListPO;
    private AddEmployeePageObject addEmployeePO;
    private PersonalDetailsPageObject personalDetailsPO;

    private PropertiesConfig propertiesConfig;

    @Parameters({"browser","server"})
    @BeforeClass
    public void beforeClass( String browser,String server){
        propertiesConfig = PropertiesConfig.getProperties(server);
        System.out.println(propertiesConfig.getApplicationUserName());
        System.out.println(propertiesConfig.getApplicationPassword());
        driver = getBrowserDriver(browser,propertiesConfig.getApplicationUrl());
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
