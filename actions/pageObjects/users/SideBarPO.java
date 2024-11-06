package pageObjects.users;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.users.SideBarUI;

public class SideBarPO extends BasePage {
    WebDriver driver;
    public SideBarPO (WebDriver driver){
        this.driver = driver;
    }

    public SideBarPO openSideBarPages(String pageName){
        waitForElementClickable(driver, SideBarUI.dynamic_pages,pageName);
        clickToElement(driver,SideBarUI.dynamic_pages,pageName);
        switch (pageName){
            case "Account Information":
                return PageGeneratorManager.getMyInforPage(driver);
            case "Address Book":
                return PageGeneratorManager.getMyAdressBookPage(driver);
            default:
                 throw new RuntimeException("Pagename is not valid");
        }
    }

    public void openSideBarPage(String pageName){
        waitForElementClickable(driver,SideBarUI.dynamic_pages,pageName);
        clickToElement(driver,SideBarUI.dynamic_pages,pageName);
    }





}
