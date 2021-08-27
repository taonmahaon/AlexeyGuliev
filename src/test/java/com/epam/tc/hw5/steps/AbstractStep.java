package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.cucumber.context.TestContext;
import com.epam.tc.hw5.pages.BaseJdiTestingPage;
import com.epam.tc.hw5.pages.DifferentElementsPage;
import com.epam.tc.hw5.pages.HomePage;
import com.epam.tc.hw5.pages.UserTablePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractStep {

    protected HomePage homePage;
    protected BaseJdiTestingPage baseJdiTestingPage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;

    public AbstractStep() {
        WebDriver driver = TestContext.getInstance().getDriver();
        WebDriverWait wait = TestContext.getInstance().getWait();
        homePage = new HomePage(driver, wait);
        differentElementsPage = new DifferentElementsPage(driver, wait);
        baseJdiTestingPage = new BaseJdiTestingPage(driver, wait);
        userTablePage = new UserTablePage(driver, wait);

    }
}
