package pageObjectt.jQuery;

import org.openqa.selenium.WebDriver;

public class PageManagerJquery {
    public static HomeJquery getHomeJquery(WebDriver driver){
        return new HomeJquery(driver);
    }
}
