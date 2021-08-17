package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.BaseSiteTestData;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class JdiTestingEx1 extends BaseSiteTestData {
    @Test
    public void softAssertsTestEx1() {



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

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        wait.until(ExpectedConditions.visibilityOfAllElements(
            webDriver.findElements(By.xpath("//ul[contains(@class, 'm-l8')]/li"))));
        List<WebElement> menuTabs = webDriver.findElements(
            By.xpath("//ul[contains(@class, 'm-l8')]/li"));
        softAssertions.assertThat(menuTabs.size()).isEqualTo(4);
        List<String> menuList = menuTabs.stream().map(WebElement::getText).collect(Collectors.toList());
        softAssertions.assertThat(menuList).isEqualTo(HEADER_EXPECTED_TEXT);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        wait.until(ExpectedConditions.visibilityOfAllElements(
            webDriver.findElements(By.cssSelector(".benefit-icon"))));
        List<WebElement> images = webDriver.findElements(By.cssSelector(".benefit-icon"));
        softAssertions.assertThat(images.size()).isEqualTo(4);

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        wait.until(ExpectedConditions.visibilityOfAllElements(
            webDriver.findElements(By.cssSelector(".benefit-txt"))));
        List<WebElement> texts = webDriver.findElements(By.cssSelector(".benefit-txt"));
        List<String> benefitList = texts.stream().map(WebElement::getText).collect(Collectors.toList());
        softAssertions.assertThat(benefitList).isEqualTo(BENEFIT_EXPECTED_TEXT);

        // 8. Assert that there is the iframe with “Frame Button” exist
        WebElement iframe = wait.until(ExpectedConditions.visibilityOf(
            webDriver.findElement(By.xpath("//iframe[@id='frame']"))));
        softAssertions.assertThat((iframe).isDisplayed()).isTrue();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame("frame");
        softAssertions.assertThat(webDriver.findElement(By.xpath(
            "//input[@value='Frame Button']")).isDisplayed()).isTrue();

        // 10. Switch to original window back
        webDriver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftMenu = wait.until(ExpectedConditions.visibilityOfAllElements(
            webDriver.findElements(By.xpath("//ul[@class='sidebar-menu left']/li/a"))));
        softAssertions.assertThat(leftMenu.size()).isEqualTo(5);
        List<String> sidebarList = leftMenu.stream().map(WebElement::getText).collect(Collectors.toList());
        softAssertions.assertThat(sidebarList).isEqualTo(SIDEBAR_EXPECTED_TEXTS);

        softAssertions.assertAll();
    }
}
