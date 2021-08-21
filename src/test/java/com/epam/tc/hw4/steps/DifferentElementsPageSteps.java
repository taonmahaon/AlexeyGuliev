package com.epam.tc.hw4.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw4.pages.DifferentElementsPage;
import io.qameta.allure.Step;
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

    public DifferentElementsPageSteps(WebDriver driver, WebDriverWait wait) {
        differentElementsPage = new DifferentElementsPage(driver, wait);
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    @Step("Assert Log")
    public void assertLog(List<String> expectedKeyWords) {
        List<WebElement> logRows = wait.until(ExpectedConditions.visibilityOfAllElements(
            differentElementsPage.getLogRows()));
        /* wanted to make a nice comparison of collections without a loop, but I don't know how can I do it Т_Т */
        for (int i = 0; i < logRows.size(); i++) {
            assertThat(logRows.get(i).getText()).contains(expectedKeyWords.get(i));
        }
    }
}
