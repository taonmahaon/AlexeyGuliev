package com.epam.tc.hw5.pages;

import static com.epam.tc.hw4.Constants.LOG_EXPECTED_TEXT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DifferentElementsPage extends BaseJdiTestingPage {

    @FindBy(xpath = "//label[normalize-space()='Water']/input")
    private WebElement waterCheckbox;

    @FindBy(xpath = "//label[normalize-space()='Wind']/input")
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

    public boolean assertCheckboxesChecked() {
        return waterCheckbox.isSelected() && windCheckbox.isSelected();

    }



    public void selectRadio() {
        wait.until(ExpectedConditions.elementToBeClickable(selenRadio)).click();
    }

    public boolean assertRadioChecked() {
        return selenRadio.isSelected();
    }

    public void selectInDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(dropdownField)).click();
        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.elementToBeClickable(yellowDropdown)).click();
    }

    public boolean assertYellowDropdownChecked() {
        return selenRadio.isSelected();
    }

    public List<WebElement> getLogRows() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(logRows));
    }

    public void assertLog() {
        List<WebElement> logRows = getLogRows();
        for (int i = 0; i < logRows.size(); i++) {
            assertThat(logRows.get(i).getText()).contains(LOG_EXPECTED_TEXT.get(i));
        }
    }

}
