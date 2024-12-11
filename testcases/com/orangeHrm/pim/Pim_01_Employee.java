package com.orangeHrm.pim;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Pim_01_Employee extends BaseTest {
    private WebDriver driver;


    @Parameters({"url","browser"})
    @BeforeClass
    public void beforeClass(String url, String browser){
        driver = getBrowserDriver(browser,url);
    }

    @Test
    public void Employee_01_Add_new(){
        log.info("step 1: demo 1");
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
