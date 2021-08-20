package com.epam.tc.hw3.steps;

import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.HomePage;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageSteps {

    private final HomePage homePage;
    SoftAssertions softAssertions = new SoftAssertions();

    public HomePageSteps(WebDriver driver, WebDriverWait wait) {
        homePage = new HomePage(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void assertBenefitImages(int numberOfImages) {
        softAssertions.assertThat(homePage.getBenefitImages().size()).isEqualTo(numberOfImages);
    }

    public void assertBenefitTexts(List<String> properTexts) {
        softAssertions.assertThat(homePage.getBenefitTexts()).isEqualTo(properTexts);
    }

    public void assertFrameExist() {
        softAssertions.assertThat((homePage.getFrameCard()).isDisplayed()).isTrue();
    }

    public void assertButtonExist() {
        softAssertions.assertThat(homePage.frameButtonDisplayed()).isTrue();
    }
}
