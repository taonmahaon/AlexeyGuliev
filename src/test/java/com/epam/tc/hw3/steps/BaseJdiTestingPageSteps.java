package com.epam.tc.hw3.steps;

import com.epam.tc.hw3.pages.BaseJdiTestingPage;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseJdiTestingPageSteps {

    private final BaseJdiTestingPage baseJdiTestingPage;
    SoftAssertions softAssertions = new SoftAssertions();

    public BaseJdiTestingPageSteps(WebDriver driver, WebDriverWait wait) {
        baseJdiTestingPage = new BaseJdiTestingPage(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void assertBrowserTitle(String browserTitle) {
        softAssertions.assertThat(baseJdiTestingPage.getPageTitle()).isEqualTo(browserTitle);
    }

    public void assertUsernameLoggedIn(String userName) {
        softAssertions.assertThat(baseJdiTestingPage.getUserName()).isEqualTo(userName);
    }

    public void assertHeaderSection(int menuTabSize, List<String> properTexts) {
        softAssertions.assertThat(baseJdiTestingPage.getMenuTabs().size()).isEqualTo(menuTabSize);
        softAssertions.assertThat(baseJdiTestingPage.getMenuTabsTexts()).isEqualTo(properTexts);
    }

    public void assertLeftMenu(int menuSize, List<String> properTexts) {
        softAssertions.assertThat(baseJdiTestingPage.getLeftMenu().size()).isEqualTo(menuSize);
        softAssertions.assertThat(baseJdiTestingPage.getLeftMenuTexts()).isEqualTo(properTexts);
    }
}
