package com.epam.tc.hw3.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw3.pages.BaseJdiTestingPage;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseJdiTestingPageSteps {

    private final BaseJdiTestingPage baseJdiTestingPage;


    public BaseJdiTestingPageSteps(WebDriver driver, WebDriverWait wait) {
        baseJdiTestingPage = new BaseJdiTestingPage(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void assertBrowserTitle(String browserTitle) {
        assertThat(baseJdiTestingPage.getPageTitle()).isEqualTo(browserTitle);
    }

    public void assertUsernameLoggedIn(String userName) {
        assertThat(baseJdiTestingPage.getUserName()).isEqualTo(userName);
    }

    public void assertHeaderSection(int menuTabSize, List<String> properTexts) {
        assertThat(baseJdiTestingPage.getMenuTabs().size()).isEqualTo(menuTabSize);
        assertThat(baseJdiTestingPage.getMenuTabsTexts()).isEqualTo(properTexts);
    }

    public void assertLeftMenu(int menuSize, List<String> properTexts) {
        assertThat(baseJdiTestingPage.getLeftMenu().size()).isEqualTo(menuSize);
        assertThat(baseJdiTestingPage.getLeftMenuTexts()).isEqualTo(properTexts);
    }
}
