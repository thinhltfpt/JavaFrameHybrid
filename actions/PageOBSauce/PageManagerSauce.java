package PageOBSauce;

import org.openqa.selenium.WebDriver;

public class PageManagerSauce {
    public static LoginSauce getLoginSauce(WebDriver driver){
        return new LoginSauce(driver);
    }

    public static ProductSauce getProductSauce(WebDriver driver){
        return new ProductSauce(driver);
    }
}
