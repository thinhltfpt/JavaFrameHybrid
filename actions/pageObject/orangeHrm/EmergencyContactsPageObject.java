package pageObject.orangeHrm;

import commons.BasePage;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class EmergencyContactsPageObject extends BaseActions {
    private WebDriver driver;

    public EmergencyContactsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
