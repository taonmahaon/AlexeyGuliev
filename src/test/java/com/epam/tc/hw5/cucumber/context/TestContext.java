package com.epam.tc.hw5.cucumber.context;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestContext {

    private static TestContext instance;

    private final Map<String, Object> context = new HashMap<>();
    private WebDriver driver;
    private WebDriverWait wait;

    private TestContext() {
    }

    public void clean() {
        context.clear();
        instance = null;
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }
    
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }
}


