package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.admin.AdminDashboardPO;
import pageObjects.admin.AdminLoginPO;
import pageObjects.users.LoginPageOB;
import pageObjects.users.*;

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

    public static LoginPageOB getLoginPage(WebDriver driver){
        return new LoginPageOB(driver);
    }

    public static WishlistPageObject getWishlistLink(WebDriver driver) {
        return new WishlistPageObject(driver);
    }



    // admin page
    public static AdminLoginPO getAdminLoginPage(WebDriver driver){
        return new AdminLoginPO(driver);
    }
    public static AdminDashboardPO getAdminDashboardPage(WebDriver driver){
        return new AdminDashboardPO(driver);
    }
}
