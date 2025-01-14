package com.saucelab.sort;

import PageOBSauce.LoginSauce;
import PageOBSauce.ProductSauce;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjectt.jQuery.table.PageManagerJquery;
import pageObjectt.jQuery.upload.UploadPageOb;

public class Topic_sort_ASC_DESC extends BaseTest {
    private WebDriver driver;
    private LoginSauce loginSauce;
    private ProductSauce productSauce;
    private  String userName, password;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browser, String url) {
        driver = getBrowserDriver(browser, url);
        userName = "standard_user";
        password = "secret_sauce";
        loginSauce = new LoginSauce(driver);
        loginSauce.addUserName(userName);
        loginSauce.addPassword(password);
        productSauce = loginSauce.clickToLogin();

    }

    @Test
    public void TC_01_Sort_ASC_DESC() {
        productSauce.selectItemToSortDropdown("Name (A to Z)");
        Assert.assertTrue(productSauce.isProductNameSortAscending());

        productSauce.selectItemToSortDropdown("Name (Z to A)");
        Assert.assertTrue(productSauce.isProductNameSortDescending());

    }

    @Test
    public void TC_02_Sort_Price_Float() {
        productSauce.selectItemToSortDropdown("Price (low to high)");
        Assert.assertTrue(productSauce.isProductPriceSortLowToHigh());

        productSauce.selectItemToSortDropdown("Price (high to low)");
        Assert.assertTrue(productSauce.isProductPriceSortHighToLow());

    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
        // closeBrowser();
    }
}
