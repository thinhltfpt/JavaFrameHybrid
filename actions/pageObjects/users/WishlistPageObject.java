package pageObjects.users;

import org.openqa.selenium.WebDriver;
import pageUIs.users.HomePageUI;

public class WishlistPageObject extends PopUpPageObject {
    private WebDriver driver;
    public WishlistPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void clickToPopupListAccount(){
        clickToElement(driver, HomePageUI.popUpAccount);
    }


}
