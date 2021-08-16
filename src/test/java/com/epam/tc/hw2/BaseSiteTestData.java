package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseSiteTestData {

    protected WebDriver webDriver;
    protected SoftAssertions softAssertions;
    protected WebDriverWait wait;
    protected String name;
    protected String password;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        name = "Roman";
        password = "Jdi1234";
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        softAssertions = new SoftAssertions();
        wait = new WebDriverWait(webDriver, 5);
    }

    public void performLogin(String name, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("user-icon")))).click();
        webDriver.switchTo().activeElement();
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.id("name")))).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOf(
            webDriver.findElement(By.id("password")))).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("login-button")))).click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        name = null;
        password = null;
        webDriver.quit();
    }
}
