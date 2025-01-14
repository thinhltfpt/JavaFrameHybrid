package PageOBSauce;

import PageSauceUI.ProductSauceUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class ProductSauce extends BasePage {
    WebDriver driver;

    public ProductSauce(WebDriver driver) {
        this.driver = driver;
    }

    public void selectItemToSortDropdown(String sortName) {
        waitForElementClickable(driver, ProductSauceUI.SORT_DROPDOWN);
        selectItemDefaultDropdown(driver,ProductSauceUI.SORT_DROPDOWN,sortName);
        sleepInSeconds(2);
    }

    public boolean isProductNameSortAscending() {
        // tao ra 1 list product name luu lai
        List<WebElement> allProductName = getListWebElement(driver,ProductSauceUI.ALL_PRODUCT_NAME);
        ArrayList<String> actualProductName = new ArrayList<String>();

        for (WebElement actualName: allProductName){
            actualProductName.add(actualName.getText());
        }

        // clone data o tren ra 1 list khac
        List<String> expectedProductName = new ArrayList<String>();
        for (String expectName: actualProductName){
            expectedProductName.add(expectName);
        }
        // sort cai list data vua clone
        Collections.sort(expectedProductName);

        // expect la 2 list bang nhau
            return actualProductName.equals(expectedProductName);
    }

    public boolean isProductNameSortDescending() {
        List<WebElement> allProductName = getListWebElement(driver,ProductSauceUI.ALL_PRODUCT_NAME);
        ArrayList<String> actualProductName = new ArrayList<String>();

        for (WebElement actualName: allProductName){
            actualProductName.add(actualName.getText());
        }

        List<String> expectedProductName = new ArrayList<String>();
        for (String expectName: actualProductName){
            expectedProductName.add(expectName);
        }

        //sort ASC truoc
        Collections.sort(expectedProductName);
        // roi moi sort DESC bang reserve
        Collections.reverse(expectedProductName);

        return actualProductName.equals(expectedProductName);
    }

    public boolean isProductPriceSortLowToHigh() {
       List<WebElement> allPrice = getListWebElement(driver,ProductSauceUI.ALL_PRICE_NAME);
        ArrayList<Float> actualAllPrice = new ArrayList<Float>();

        for(WebElement price: allPrice){
            actualAllPrice.add(Float.parseFloat(price.getText().replace("$","").trim()));
        }

        ArrayList<Float> expectAllPrice = new ArrayList<Float>();
        for (Float expectPrice: actualAllPrice){
            expectAllPrice.add(expectPrice);
        }

        Collections.sort(expectAllPrice);
        return actualAllPrice.equals(expectAllPrice);
    }

    public boolean isProductPriceSortHighToLow() {
        List<WebElement> allPrice = getListWebElement(driver,ProductSauceUI.ALL_PRICE_NAME);
        ArrayList<Float> actualAllPrice = new ArrayList<Float>();

        for(WebElement price: allPrice){
            actualAllPrice.add(Float.parseFloat(price.getText().replace("$","").trim()));
        }

        ArrayList<Float> expectAllPrice = new ArrayList<Float>();
        for (Float expectPrice: actualAllPrice){
            expectAllPrice.add(expectPrice);
        }

        Collections.sort(expectAllPrice);
        Collections.reverse(expectAllPrice);
        return actualAllPrice.equals(expectAllPrice);
    }
}
