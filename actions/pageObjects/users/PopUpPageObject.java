package pageObjects.users;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.users.PopUpPageUI;

public class PopUpPageObject extends BasePage {
    WebDriver driver;
    public PopUpPageObject(WebDriver driver){
        this.driver = driver;
    }

    public AccountPageObject clickToAccountLink(){
        waitForElementClickable(driver, PopUpPageUI.accountLink);
        clickToElement(driver, PopUpPageUI.accountLink);
        return PageGeneratorManager.getAccountPage(driver);
    }

    public WishlistPageObject clickToWishlistLink(){
        waitForElementClickable(driver, PopUpPageUI.wishlistLink);
        clickToElement(driver, PopUpPageUI.wishlistLink);
        return PageGeneratorManager.getWishlistLink(driver);
    }







}
