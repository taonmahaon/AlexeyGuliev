package com.epam.tc.hw3.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DifferentElementsPage extends BaseJdiTestingPage {

    @FindBy(xpath = "//label[normalize-space()='Water']")
    private WebElement waterCheckbox;

    @FindBy(xpath = "//label[normalize-space()='Wind']")
    private WebElement windCheckbox;

    @FindBy(xpath = "//label[normalize-space()='Selen']")
    private WebElement selenRadio;

    @FindBy(xpath = "//select[@class='uui-form-element']")
    private WebElement dropdownField;

    @FindBy(xpath = "//option[normalize-space()='Yellow']")
    private WebElement yellowDropdown;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private List<WebElement> logRows;

    public DifferentElementsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void selectCheckboxes() {
        wait.until(ExpectedConditions.elementToBeClickable(waterCheckbox)).click();
        wait.until(ExpectedConditions.elementToBeClickable(windCheckbox)).click();
    }

    public void selectRadio() {
        wait.until(ExpectedConditions.elementToBeClickable(selenRadio)).click();
    }

    public void selectInDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(dropdownField)).click();
        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.elementToBeClickable(yellowDropdown)).click();
    }

    public List<WebElement> getLogRows() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(logRows));
    }

}
