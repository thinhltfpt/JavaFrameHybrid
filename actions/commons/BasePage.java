package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.users.AccountPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.MobilePageObject;
import pageObjects.users.TVPageObject;
import pageUIs.BasePageUI;
import pageUIs.users.PopUpPageUI;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    // biến toàn cục, phạm vi class
//    WebDriver driver;

    // hàm static này có tác dụng: ko cần khởi tạo đối tượng mà vẫn truy cập vào hàm này được
    // truy cập trực tiếp từ phạm vị class con
    public static BasePage getBasePage(){
        return new BasePage();
    }

    /* Web browser */
    public void openPageURL(WebDriver driver, String pageURL) {
        // biến cục bộ
        driver.get(pageURL);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentPageURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSourceCode(WebDriver driver) {
        return driver.getPageSource();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refeshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    // alert
    public Alert waitForAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptToAlert(WebDriver driver) {
        waitForAlertPresence(driver).accept();
    }

    public void cancelToAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    public String getTextInAlert(WebDriver driver) {
        return waitForAlertPresence(driver).getText();
    }

    public void sendkeyToAlert(WebDriver driver, String keysToSend) {
        waitForAlertPresence(driver).sendKeys(keysToSend);
    }

    // windows
    // dung` cho case duy nhat 2 tab/window
    public void switchToWindowByID(WebDriver driver, String parentID) {
        // lay ra tac ca ID cua tab/window
        Set<String> allWindows = driver.getWindowHandles();
        // dung` vong lap de duyet qua tung item trong set (allIDs)
        for (String runWindow : allWindows) {
            // trong qua trinh` duyet tung item
            // neu item nao` khac' vs parentID truyen vao`
            if (!runWindow.equals(parentID)) {
                // thi` switch vao tab/ window do'
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    // dung` cho 2 tab/ window tro len
    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            // switch vao tung ids
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            // neu dung' vs title truyen vao thi switch vao tab/ window do' - thoat khoi vong lap
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    public void sleepInSeconds(long timeSecond) {
        try {
            Thread.sleep(timeSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Cookies
    public Cookie getCookieName(WebDriver driver,String nameCookie){
        return driver.manage().getCookieNamed(nameCookie);
    }

    public Set<Cookie> getBrowserCookies(WebDriver driver) {
       return driver.manage().getCookies();
    }

    public synchronized void setCookies(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
    }

    public void deleteCookie(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    /* Web Element */
    private String castParameter(String locator,String... retParameter){
        return String.format(locator,(Object[]) retParameter);
    }

    private By getByLocator(String prefixLocator){
        By by = null;
        if (prefixLocator.toUpperCase().startsWith("ID")){
            by = By.id(prefixLocator.substring(3));
        } else if (prefixLocator.toUpperCase().startsWith("CLASS")){
            by = By.className(prefixLocator.substring(6));
        } else if (prefixLocator.toUpperCase().startsWith("NAME")){
            by = By.name(prefixLocator.substring(5));
        } else if (prefixLocator.toUpperCase().startsWith("TAGNAME")){
            by = By.tagName(prefixLocator.substring(8));
        } else if (prefixLocator.toUpperCase().startsWith("CSS")){
            by = By.cssSelector(prefixLocator.substring(4));
        } else if (prefixLocator.toUpperCase().startsWith("XPATH")){
            by = By.xpath(prefixLocator.substring(6));
        } else {
            throw new RuntimeException("Location type is not support");
        }
        return by;
    }

    private By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public WebElement getWebElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }

    public List<WebElement> getListWebElement(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }
    public List<WebElement> getListWebElement(WebDriver driver, String locator,String restParameter) {
        return driver.findElements(getByLocator(castParameter(locator,restParameter)));
    }

    public void clickToElement(WebDriver driver, String locator) {
        getWebElement(driver, locator).click();
    }
    public void clickToElement(WebDriver driver, WebElement element) {
        element.click();
    }

    public void clickToElement(WebDriver driver, String locator, String... restParameter) {
        getWebElement(driver, castParameter(locator,restParameter)).click();
    }

    public void sendkeyElement(WebDriver driver, String locator, String valueToSend) {
        getWebElement(driver, locator).clear();
        getWebElement(driver, locator).sendKeys(valueToSend);
    }

    public void sendkeyElement(WebDriver driver, String locator, String valueToSend, String... restParameter) {
        getWebElement(driver, castParameter(locator,restParameter)).clear();
        getWebElement(driver, castParameter(locator,restParameter)).sendKeys(valueToSend);
    }

    public void uploadMuiltipleFiles(WebDriver driver, String... fileNames){
        String filePath = GlobalConstants.UPLOAD_PATH;
        String fullFileName = "";
        for (String file : fileNames){
            fullFileName = fullFileName + filePath + file + "\n";
        }
        fullFileName = fullFileName.trim();
        getWebElement(driver,BasePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
    }

//    public String getElementText(WebDriver driver, String locator){
//        return getWebElement(driver,locator).getText();
//    }

    // Default dropdown
    public void selectItemDefaultDropdown(WebDriver driver, String locator, String itemValue) {
        new Select(getWebElement(driver, locator)).selectByVisibleText(itemValue);
    }

    public void selectItemDefaultDropdown(WebDriver driver, String locator, String itemValue,String... restParameter) {
        new Select(getWebElement(driver, castParameter(locator,restParameter))).selectByVisibleText(itemValue);
    }

    public String getFirstSelectedTextInDefaultDropdown(WebDriver driver, String locator) {
        return new Select(getWebElement(driver, locator)).getFirstSelectedOption().getText();
    }

    public Boolean isDefaultDropdownMultiple(WebDriver driver, String locator) {
        return new Select(getWebElement(driver, locator)).isMultiple();
    }

    // Custom dropdown
    public void SelectItemDropdown(WebDriver driver, String parentLocator, String dropdownList, String expectedTextItem) {
        getWebElement(driver, parentLocator).click();
        sleepInSeconds(2);
        List<WebElement> dropDownItems = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(dropdownList)));
        for (WebElement tempItem : dropDownItems) {
            if (tempItem.getText().trim().equals(expectedTextItem)) {
                sleepInSeconds(1);
                tempItem.click();
                break;
            }
        }
    }

    // ham getText
    public String getElementText(WebDriver driver, String locator) {
        return getWebElement(driver, locator).getText();
    }
    public String getElementText(WebDriver driver, String locator, String... restParmeter) {
        return getWebElement(driver, castParameter(locator,restParmeter)).getText();
    }

    public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
        return getWebElement(driver, locator).getAttribute(attributeName);
    }
    public String getElementAttribute(WebDriver driver, String locator, String attributeName,String... restParmeter) {
        return getWebElement(driver, castParameter(locator,restParmeter)).getAttribute(attributeName);
    }

    public String getElementCssValue(WebDriver driver, String locator, String cssPropertyName) {
        return getWebElement(driver, locator).getCssValue(cssPropertyName);
    }
    public String getElementCssValue(WebDriver driver, String locator, String cssPropertyName,String... restParmeter) {
        return getWebElement(driver, castParameter(locator,restParmeter)).getCssValue(cssPropertyName);
    }

    public String convertRGBToHexaColor(WebDriver driver, String locator) {
        return Color.fromString(getElementCssValue(driver, locator, "background-color")).asHex();
    }

    public int getListElementSize(WebDriver driver, String locator) {
        return getListWebElement(driver, locator).size();
    }
    public int getListElementSize(WebDriver driver, String locator,String... restParameter) {
        return getListWebElement(driver, castParameter(locator,restParameter)).size();
    }

    /*
     * Apply for checkbox and radio
     * */
    public void checkToElement(WebDriver driver, String locator) {
        if (!getWebElement(driver, locator).isSelected()) {
            getWebElement(driver, locator).click();
        }
    }
    public void checkToElement(WebDriver driver, String locator,String... restParameter) {
        if (!getWebElement(driver, castParameter(locator,restParameter)).isSelected()) {
            getWebElement(driver, castParameter(locator,restParameter)).click();
        }
    }

    /*
     *  Only apply for checkbox
     * */
    public void uncheckToElement(WebDriver driver, String locator) {
        if (getWebElement(driver, locator).isSelected()) {
            getWebElement(driver, locator).click();
        }
    }

    public Boolean isElementDisplayed(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isDisplayed();
    }
    public Boolean isElementDisplayed(WebDriver driver, String locator,String... restParmeter) {
        return getWebElement(driver, castParameter(locator,restParmeter)).isDisplayed();
    }

    public Boolean isElementEnabled(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isEnabled();
    }
    public Boolean isElementEnabled(WebDriver driver, String locator,String... restParmeter) {
        return getWebElement(driver, castParameter(locator,restParmeter)).isEnabled();
    }

    public boolean isElementSelected(WebDriver driver,String locator){
        return getWebElement(driver,locator).isSelected();
    }
    public boolean isElementSelected(WebDriver driver,String locator, String... restParmeter){
        return getWebElement(driver,castParameter(locator,restParmeter)).isSelected();
    }

    // Frame/ Iframe
    public void switchToIframe(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByLocator(locator)));
    }

    public void switchToDefaultContent(WebDriver driver, String locator) {
        driver.switchTo().defaultContent();
    }

    /*
     *  User Interaction - Actions
     * */

    public void hoverToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getWebElement(driver, locator)).perform();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        new Actions(driver).doubleClick(getWebElement(driver, locator)).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getWebElement(driver, locator)).perform();
    }

    public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
        new Actions(driver).dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator)).perform();
    }

    public void scrollToElement(WebDriver driver, String locator) {
        new Actions(driver).scrollToElement(getWebElement(driver, locator)).perform();
    }

    public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
        new Actions(driver).sendKeys(getWebElement(driver, locator), key).perform();
    }

    /*
     *  Wait
     * */
    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }
    public void waitForElementVisible(WebDriver driver, String locator,String... restParmeter) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castParameter(locator,restParmeter))));
    }

    public void waitForElementSelected(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
    }
    public void waitForElementSelected(WebDriver driver,String locator,String... restParmeter){
        new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeSelected(getByLocator(castParameter(locator,restParmeter))));
    }

    public void waitForListElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, locator)));
    }
    public void waitForListElementVisible(WebDriver driver, String locator,String... restParmeter) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, castParameter(locator,restParmeter))));
    }

    public void waitForElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }
    public void waitForElementInvisible(WebDriver driver, String locator,String... restParmeter) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(castParameter(locator,restParmeter))));
    }

    public void waitForListElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(getWebElement(driver, locator)));
    }
    public void waitForElementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitForElementClickable(WebDriver driver, String locator,String... restParmeter) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(getWebElement(driver, castParameter(locator,restParmeter))));
    }

    public void waitForTextVisible(WebDriver driver, String locator, String textExpect) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.textToBePresentInElementLocated(getByLocator(locator),textExpect));
    }


    // Java Excuter
    public void hightlightElement(WebDriver driver, String locator) {
        WebElement element = getWebElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSeconds(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator));
        sleepInSeconds(3);
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
    }

    public void scrollToElementOnDownByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, locator));
    }

    public void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getWebElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
    }

    public String getAttributeInDOMByJS(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getWebElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                        "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getWebElement(driver, locator));
    }





    // Switch pageObject
    public HomePageObject clickToHomePage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.HomePageLink);
        clickToElement(driver,BasePageUI.HomePageLink);
        return PageGeneratorManager.getHomePage(driver);
    }

    public TVPageObject clickToTVPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.TVLink);
        clickToElement(driver, BasePageUI.TVLink);
        return PageGeneratorManager.getTVPage(driver);
    }

    public MobilePageObject clickToMobileLink(WebDriver driver){
        waitForElementClickable(driver, BasePageUI.MobileLink);
        clickToElement(driver, BasePageUI.MobileLink);
        return PageGeneratorManager.getMobilePage(driver);
    }


    public AccountPageObject clickToAccountLink(WebDriver driver) {
        waitForElementClickable(driver, PopUpPageUI.accountLink);
        clickToElement(driver, PopUpPageUI.accountLink);
        return PageGeneratorManager.getAccountPage(driver);
    }






}
