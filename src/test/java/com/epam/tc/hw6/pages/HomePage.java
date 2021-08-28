package com.epam.tc.hw6.pages;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseJdiTestingPage {

    @FindBy(css = ".benefit-icon")
    private List<WebElement> benefitImages;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> benefitTexts;

    @FindBy(xpath = "//iframe[@id='frame']")
    private WebElement frameCard;

    @FindBy(xpath = "//input[@value='Frame Button']")
    private WebElement frameButton;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public List<WebElement> getBenefitImages() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(benefitImages));

    }

    public List<String> getBenefitTexts() {
        wait.until(ExpectedConditions.visibilityOfAllElements(benefitTexts));
        return benefitTexts.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public WebElement getFrameCard() {
        return wait.until(ExpectedConditions.visibilityOf(frameCard));
    }

    public Boolean frameButtonDisplayed() {
        driver.switchTo().frame("frame");
        return frameButton.isDisplayed();
    }

    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }
}

