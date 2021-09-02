package com.epam.tc.hw6.pages;

import com.epam.tc.hw4.utils.GetPropertyFile;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseJdiTestingPage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@id='user-name']")
    private WebElement userName;

    @FindBy(xpath = "//ul[contains(@class, 'm-l8')]/li")
    private List<WebElement> menuTabs;

    @FindBy(xpath = "//ul[@class='sidebar-menu left']/li/a")
    private List<WebElement> leftMenu;

    @FindBy(xpath = "//span[contains(.,'Service')]")
    private WebElement serviceMenu;

    @FindBy(xpath = "//span[contains(.,'Different elements')]")
    private WebElement diffElementsLink;

    public BaseJdiTestingPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }


    public void login() {
        wait.until(ExpectedConditions.elementToBeClickable(userIcon)).click();
        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.visibilityOf(nameField))
            .sendKeys(GetPropertyFile.getProperty().getProperty("name"));
        wait.until(ExpectedConditions.visibilityOf(passwordField))
            .sendKeys(GetPropertyFile.getProperty().getProperty("password"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void openSiteByUrl(String url) {
        driver.navigate().to(url);
    }

    public String getUserName() {
        return wait.until(ExpectedConditions.visibilityOf(userName)).getText();
    }

    public List<WebElement> getMenuTabs() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(menuTabs));
    }

    public List<String> getMenuTabsTexts() {
        return menuTabs.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<WebElement> getLeftMenu() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(leftMenu));
    }

    public List<String> getLeftMenuTexts() {
        return leftMenu.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void openDifferentElementsPageThroughServiceMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(serviceMenu)).click();
        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.elementToBeClickable(diffElementsLink)).click();
    }

}
