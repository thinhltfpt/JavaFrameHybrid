package com.jquery.table;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectt.jQuery.table.HomeJquery;
import pageObjectt.jQuery.table.PageManagerJquery;

import java.util.ArrayList;
import java.util.List;

public class Topic_handle_data_table extends BaseTest {
    private WebDriver driver;
    private HomeJquery homeJquery;
    private List<String> allValueUI = new ArrayList<String>();

    // multi browser
    @Parameters({"browser", "url"})  // denpendencies injection
    @BeforeClass
    public void beforeClass(String browser, String url) {

        driver = getBrowserDriver(browser, url);
        homeJquery = PageManagerJquery.getHomeJquery(driver);
    }

//    @Test
//    public void TC_01_search() {
//        // search du lieu tren header
//        homeJquery.inputToColumn("384187","Females");
//        homeJquery.sleepInSeconds(1);
//        homeJquery.inputToColumn("Afghanistan","Country");
//        homeJquery.sleepInSeconds(1);
//        homeJquery.inputToColumn("407124","Males");
//        homeJquery.sleepInSeconds(1);
//        homeJquery.inputToColumn("791312","Total");
//        homeJquery.sleepInSeconds(1);
//
//    }
//
//    @Test
//    public void TC_02_Paging() {
//        homeJquery.clickPaging("2");
//        homeJquery.sleepInSeconds(2);
//        Assert.assertTrue(homeJquery.isPageNumberDisplayed("2"));
//    }
//
//    @Test
//    public void TC_03_checkDisplayed(){
//        Assert.assertTrue(homeJquery.isRowDisplayed("32919696","ASIA"));
//    }
//
//    @Test
//    public void TC_04_Icon_Action(){
//        homeJquery.clickToRowAction("ASIA","edit");
//        homeJquery.sleepInSeconds(1);
//        homeJquery.refeshCurrentPage(driver);
//        homeJquery.clickToRowAction("Afghanistan","remove");
//        homeJquery.sleepInSeconds(1);
//    }
//
//    @Test
//    public void TC_05_get_all_values_column(){
//        // UI
//        allValueUI = homeJquery.getAllPageValuesbyColumnName("country");
//
////        // API: Rest Assured/
////        allValueAPI = homeJquery.getAllPageValuesbyColumnNameAPI("country");
////
////        // DB: JTDS/ SQL/ ...
////        allValueDB = homeJquery.getAllPageValuesbyColumnNameDB("country");
////        // verify du lieu UI va DB
////        Assert.assertEquals(allValueUI,allValueDB);
////
////        homeJquery.getAllPageValuesbyColumnName("total");
//    }

    @Test
    public void TC_06_action_by_index() {
        homeJquery.openPageURL(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");

        // nhap vao textbox tai cot contact person dong` thu' 2
        homeJquery.enterToTextboxByColumnNameAndRowIndex("Contact Person", "2", "Torres");
        homeJquery.enterToTextboxByColumnNameAndRowIndex("Company", "1", "Liverpool");

        // select du lieu tai cot country dong` thu' 3
        homeJquery.selectDropdownByColumnNameAndRowIndex("Country", "3", "Japan");

        // click vao checkbox tai cot NPO? dong` thu' 1
        homeJquery.clickToCheckboxByColumnNameAndRowIndex("NPO?","2");
        homeJquery.clickToCheckboxByColumnNameAndRowIndex("NPO?","1");
        homeJquery.clickToCheckboxByColumnNameAndRowIndex("NPO?","3");

    }


    @AfterClass
    public void afterClass() {
        //driver.quit();
        // closeBrowser();
    }
}
