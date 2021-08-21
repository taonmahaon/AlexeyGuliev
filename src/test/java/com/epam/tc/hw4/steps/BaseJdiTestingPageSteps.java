package com.epam.tc.hw4.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw4.pages.BaseJdiTestingPage;
import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseJdiTestingPageSteps {

    private final BaseJdiTestingPage baseJdiTestingPage;

    public BaseJdiTestingPageSteps(WebDriver driver, WebDriverWait wait) {
        baseJdiTestingPage = new BaseJdiTestingPage(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @Step("Assert Browser Title")
    public void assertBrowserTitle(String browserTitle) {
        assertThat(baseJdiTestingPage.getPageTitle()).isEqualTo(browserTitle);

    }

    @Step("Assert Username LoggedIn")
    public void assertUsernameLoggedIn(String userName) {
        assertThat(baseJdiTestingPage.getUserName()).isEqualTo(userName);
    }

    @Step("Assert Header Section")
    public void assertHeaderSection(int menuTabSize, List<String> properTexts) {
        assertThat(baseJdiTestingPage.getMenuTabs().size()).isEqualTo(menuTabSize);
        assertThat(baseJdiTestingPage.getMenuTabsTexts()).isEqualTo(properTexts);
    }

    @Step("Assert Left Menu")
    public void assertLeftMenu(int menuSize, List<String> properTexts) {
        assertThat(baseJdiTestingPage.getLeftMenu().size()).isEqualTo(menuSize);
        assertThat(baseJdiTestingPage.getLeftMenuTexts()).isEqualTo(properTexts);
    }

}
