package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.AccountPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.MobilePageObject;
import pageObjects.nopCommerce.TVPageObject;

public class PageGeneratorManager {

    public static HomePageObject getHomePage(WebDriver driver){
        return  new HomePageObject(driver);
    }

    public static MobilePageObject getMobilePage(WebDriver driver){
        return  new MobilePageObject(driver);
    }

    public static TVPageObject getTVPage(WebDriver driver){
        return  new TVPageObject(driver);
    }

    public static AccountPageObject getAccountPage(WebDriver driver){
        return new AccountPageObject(driver);
    }




}
