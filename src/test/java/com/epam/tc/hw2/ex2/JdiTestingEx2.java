package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.BaseSiteTestData;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class JdiTestingEx2 extends BaseSiteTestData {

    @Test
    public void interactiveElementsTestEx2() {
        // 1. Open test site by URL
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 2. Assert Browser title
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo("Home Page");

        // 3. Perform login
        performLogin(name, password);

        // 4. Assert Username is logged in
        String userName = wait.until(ExpectedConditions.visibilityOf(
            webDriver.findElement(By.xpath("//span[@id='user-name']")))).getText();
        softAssertions.assertThat(userName).isEqualTo("ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        wait.until(ExpectedConditions.elementToBeClickable(
            webDriver.findElement(By.xpath("//span[contains(.,'Service')]")))).click();
        webDriver.switchTo().activeElement();
        wait.until(ExpectedConditions.elementToBeClickable(
            webDriver.findElement(By.xpath("//span[contains(.,'Different elements')]")))).click();

        // 6. Select checkboxes
        wait.until(ExpectedConditions.elementToBeClickable(
            webDriver.findElement(By.xpath("//label[normalize-space()='Water']")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
            webDriver.findElement(By.xpath("//label[normalize-space()='Wind']")))).click();

        // 7. Select radio
        wait.until(ExpectedConditions.elementToBeClickable(
            webDriver.findElement(By.xpath("//label[normalize-space()='Selen']")))).click();

        // 8. Select in dropdown
        wait.until(ExpectedConditions.elementToBeClickable(
            webDriver.findElement(By.xpath("//select[@class='uui-form-element']")))).click();
        webDriver.switchTo().activeElement();
        wait.until(ExpectedConditions.elementToBeClickable(
            webDriver.findElement(By.xpath("//option[normalize-space()='Yellow']")))).click();

        // 9. Assert that:
        // a) for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        // b)  radio button there is a log row and value is corresponded to the status of radio button
        // c) dropdown there is a log row and value is corresponded to the selected value.
        List<WebElement> logRows = wait.until(ExpectedConditions.visibilityOfAllElements(
            webDriver.findElements(By.xpath("//ul[@class='panel-body-list logs']/li"))));
        softAssertions.assertThat(logRows.get(0).getText()).contains("Yellow");
        softAssertions.assertThat(logRows.get(1).getText()).contains("Selen");
        softAssertions.assertThat(logRows.get(2).getText()).contains("Wind");
        softAssertions.assertThat(logRows.get(3).getText()).contains("Water");
        softAssertions.assertAll();
    }
}
