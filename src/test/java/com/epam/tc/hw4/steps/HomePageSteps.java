package com.epam.tc.hw4.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw4.pages.HomePage;
import io.qameta.allure.Step;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageSteps {

    private final HomePage homePage;

    public HomePageSteps(WebDriver driver, WebDriverWait wait) {
        homePage = new HomePage(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @Step("Assert Benefit Images")
    public void assertBenefitImages(int numberOfImages) {
        assertThat(homePage.getBenefitImages().size()).isEqualTo(numberOfImages);
    }

    @Step("Assert Benefit Texts")
    public void assertBenefitTexts(List<String> properTexts) {
        assertThat(homePage.getBenefitTexts()).isEqualTo(properTexts);
    }

    @Step("Assert Frame Exist")
    public void assertFrameExist() {
        assertThat((homePage.getFrameCard()).isDisplayed()).isTrue();
    }

    @Step("Assert Frame Button Exist")
    public void assertButtonExist() {
        assertThat(homePage.frameButtonDisplayed()).isTrue();
    }
}
