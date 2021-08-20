package com.epam.tc.hw3.steps;

import com.epam.tc.hw3.pages.DifferentElementsPage;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DifferentElementsPageSteps {

    private final WebDriverWait wait;
    private final DifferentElementsPage differentElementsPage;
    SoftAssertions softAssertions = new SoftAssertions();

    public DifferentElementsPageSteps(WebDriver driver, WebDriverWait wait) {
        differentElementsPage = new DifferentElementsPage(driver, wait);
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    public void assertLog(List<String> expectedKeyWords) {
        List<WebElement> logRows = wait.until(ExpectedConditions.visibilityOfAllElements(
            differentElementsPage.getLogRows()));
        /* wanted to make a nice comparison of collections without a loop, but I don't know how can I do it Т_Т */
        for (int i = 0; i < logRows.size(); i++) {
            softAssertions.assertThat(logRows.get(i).getText()).contains(expectedKeyWords.get(i));
        }
    }
}
