package com.epam.tc.hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AbstractBaseTest {

    protected WebDriver webDriver;
    protected WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext context) {
        webDriver = WebDriverSingleton.getDriver();
        context.setAttribute("driver", webDriver);
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, 5);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }
}

