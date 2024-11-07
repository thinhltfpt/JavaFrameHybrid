package com.jquery.table;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.users.*;
import pageObjectt.jQuery.HomeJquery;
import pageObjectt.jQuery.PageManagerJquery;

public class Topic_handle_data_table extends BaseTest {
    private WebDriver driver;
    private HomeJquery homeJquery;
    // multi browser
    @Parameters({"browser","url"})  // denpendencies injection
    @BeforeClass
    public void beforeClass(String browser, String url) {

      driver= getBrowserDriver(browser,url);
      homeJquery = PageManagerJquery.getHomeJquery(driver);
    }

    @Test
    public void TC_01_search() {
        // search du lieu tren header
        homeJquery.inputToColumn("384187","Females");
        homeJquery.sleepInSeconds(1);
        homeJquery.inputToColumn("Afghanistan","Country");
        homeJquery.sleepInSeconds(1);
        homeJquery.inputToColumn("407124","Males");
        homeJquery.sleepInSeconds(1);
        homeJquery.inputToColumn("791312","Total");
        homeJquery.sleepInSeconds(1);

    }

    @Test
    public void TC_02_Paging() {
        homeJquery.clickPaging("2");
        homeJquery.sleepInSeconds(2);
        Assert.assertTrue(homeJquery.isPageNumberDisplayed("2"));
    }

    @Test
    public void TC_03_checkDisplayed(){
        Assert.assertTrue(homeJquery.isRowDisplayed("32919696","ASIA"));
    }

    @Test
    public void TC_04_Icon_Action(){
        homeJquery.clickToRowAction("ASIA","edit");
        homeJquery.sleepInSeconds(1);
        homeJquery.refeshCurrentPage(driver);
        homeJquery.clickToRowAction("Afghanistan","remove");
        homeJquery.sleepInSeconds(1);
    }



    @AfterClass
    public void afterClass() {
        //driver.quit();
        closeBrowser();
    }
}
