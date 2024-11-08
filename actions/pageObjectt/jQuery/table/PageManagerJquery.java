package pageObjectt.jQuery.table;

import org.openqa.selenium.WebDriver;
import pageObjectt.jQuery.upload.UploadPageOb;

public class PageManagerJquery {
    public static HomeJquery getHomeJquery(WebDriver driver){
        return new HomeJquery(driver);
    }
    public static UploadPageOb getUploadPage(WebDriver driver){
        return new UploadPageOb(driver);
    }
}
