package com.jquery.upload;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjectt.jQuery.table.HomeJquery;
import pageObjectt.jQuery.table.PageManagerJquery;
import pageObjectt.jQuery.upload.UploadPageOb;

import java.util.ArrayList;
import java.util.List;

public class Topic_jquery_uploadFile extends BaseTest {
    private WebDriver driver;
    private UploadPageOb uploadPageOb;
    private String unamed = "Screenshot 2024-02-07 104902.png";
    private String screenShot ="unnamed.jpg";

    String[] fileNames = {unamed,screenShot};
    // multi browser
    @Parameters({"browser", "url"})  // denpendencies injection
    @BeforeClass
    public void beforeClass(String browser, String url) {

        driver = getBrowserDriver(browser, url);
        uploadPageOb = PageManagerJquery.getUploadPage(driver);
    }

    @Test
    public void TC_01_Upload_SingleFile() {
        SoftAssert softAssert = new SoftAssert();
        log.info("TC_01_upload_single - Step 1: upload file 1 " + unamed);
        uploadPageOb.uploadMuiltipleFiles(driver,unamed);
        uploadPageOb.sleepInSeconds(2);
        log.info("TC_01_upload_single - Step 1: upload file 2 " + screenShot);
        uploadPageOb.uploadMuiltipleFiles(driver,screenShot);
        uploadPageOb.sleepInSeconds(2);
        log.info("TC_01_upload_single - Step 3: verify loaded file 1" +unamed);
        verifyTrue(uploadPageOb.isFileLoadedSuccess(unamed));
        log.info("TC_01_upload_single - Step 4: verify loaded file 2" +screenShot);
//        verifyFalse(uploadPageOb.isFileLoadedSuccess(screenShot));
        softAssert.assertFalse(uploadPageOb.isFileLoadedSuccess(screenShot),"not success is on log");

        uploadPageOb.clickStartButtonOnEachFile();
        Assert.assertTrue(uploadPageOb.isFileUploadedSuccess(unamed));
        Assert.assertTrue(uploadPageOb.isFileUploadedSuccess(screenShot));
        softAssert.assertAll();
    }

//    @Test
    public void TC_02_Upload_MultipleFile() {
        uploadPageOb.refeshCurrentPage(driver);
        uploadPageOb.uploadMuiltipleFiles(driver,fileNames);
        Assert.assertTrue(uploadPageOb.isFileLoadedSuccess(unamed));
        Assert.assertTrue(uploadPageOb.isFileLoadedSuccess(screenShot));

        uploadPageOb.clickStartButtonOnEachFile();
        Assert.assertTrue(uploadPageOb.isFileUploadedSuccess(unamed));
        Assert.assertTrue(uploadPageOb.isFileUploadedSuccess(screenShot));
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
        // closeBrowser();
    }
}
