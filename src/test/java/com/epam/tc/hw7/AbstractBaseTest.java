package com.epam.tc.hw7;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.UIFactory.$;

import com.epam.tc.hw7.utils.LoginFromProp;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AbstractBaseTest {

    @BeforeTest()
    public void setUp() {
        LoginFromProp.login();
        $("//a[contains(@href, 'metals-colors.html')]").click();

    }

    @AfterTest()
    public void tearDown() {
        killAllSeleniumDrivers();
    }
}

