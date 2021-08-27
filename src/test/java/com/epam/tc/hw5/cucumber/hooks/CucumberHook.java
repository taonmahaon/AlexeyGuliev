package com.epam.tc.hw5.cucumber.hooks;

import com.epam.tc.hw5.cucumber.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CucumberHook {

    protected WebDriver webDriver;
    protected WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 5);
        webDriver.manage().window().maximize();
        TestContext.getInstance().setDriver(webDriver);
        TestContext.getInstance().setWait(wait);
    }

    @After
    public void tearDown() {
        webDriver.quit();
        TestContext.getInstance().clean();
    }
}
