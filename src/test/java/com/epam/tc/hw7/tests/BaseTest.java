package com.epam.tc.hw7.tests;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.tc.hw7.sites.JdiTestingSite.homePage;
import static com.epam.tc.hw7.sites.pages.HomePage.loginForm;
import static com.epam.tc.hw7.sites.pages.HomePage.signInIcon;

import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.sites.JdiTestingSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        initSite(JdiTestingSite.class);
        homePage.open();
        homePage.checkOpened();
        signInIcon.click();
        loginForm.loginAs(User.USER_ROMAN);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        homePage.logout();
        killAllSeleniumDrivers();
    }
}

