package com.epam.tc.hw3.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseJdiTestingPage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final SoftAssertions softAssertions;

    public BaseJdiTestingPage(WebDriver driver, WebDriverWait wait, SoftAssertions softAssertions) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
        this.softAssertions = softAssertions;
    }

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

    public String getPageTitle() {
        return driver.getTitle();
    }


    public void login() {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(userIcon)).click();
        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.visibilityOf(nameField)).sendKeys(prop.getProperty("name"));
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(prop.getProperty("password"));
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

    public void assertBrowserTitle(String browserTitle) {
        softAssertions.assertThat(getPageTitle()).isEqualTo(browserTitle);
    }

    public void assertUsernameLoggedIn(String userName) {
        softAssertions.assertThat(getUserName()).isEqualTo(userName);
    }

    public void assertHeaderSection(int menuTabSize, List<String> properTexts) {
        softAssertions.assertThat(getMenuTabs().size()).isEqualTo(menuTabSize);
        softAssertions.assertThat(getMenuTabsTexts()).isEqualTo(properTexts);
    }

    public void assertLeftMenu(int menuSize, List<String> properTexts) {
        softAssertions.assertThat(getLeftMenu().size()).isEqualTo(menuSize);
        softAssertions.assertThat(getLeftMenuTexts()).isEqualTo(properTexts);
    }
}
