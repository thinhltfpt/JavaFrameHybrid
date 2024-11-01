package pageObject.factory;

import commons.BasePage;
import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class CustomerPageObject extends BasePageFactory {
    // khoi tao driver
    WebDriver driver;

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//a[text()='Mobile']")
    private WebElement MobileLink;

    @CacheLookup
    @FindBy(xpath = "//a[text()='TV']")
    private WebElement TVLink;

//    @FindBys({@FindBy(xpath = "//span[text()='Account']/parent::a[@class='skip-link skip-account']"),@FindBy(xpath = "")})
//    private WebElement accountLink;

    @FindBy(xpath = "//span[text()='Account']/parent::a[@class='skip-link skip-account']")
    private WebElement accountLink;

    // khoi tao
    public CustomerPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }


    public void getURL() {
        openPageURL(driver,"https://live.techpanda.org/index.php/");
    }

    public void clickToMobileLink(){
        waitForElementVisible(driver,MobileLink);
        MobileLink.click();
    }

    public void clickToTVLink(){
        waitForElementVisible(driver,TVLink);
        TVLink.click();
    }

}
