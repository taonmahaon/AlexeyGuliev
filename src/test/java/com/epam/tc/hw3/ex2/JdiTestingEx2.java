package com.epam.tc.hw3.ex2;

import com.epam.tc.hw3.TestDataHw3;
import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.HomePage;
import org.testng.annotations.Test;

public class JdiTestingEx2 extends TestDataHw3 {

    @Test
    public void interactiveElementsTestEx2() {

        final HomePage homePage = new HomePage(webDriver, wait, softAssertions);
        final DifferentElementsPage differentElementsPage = new DifferentElementsPage(webDriver, wait, softAssertions);

        // 1. Open test site by URL
        homePage.openSiteByUrl(URL);

        // 2. Assert Browser title
        homePage.assertBrowserTitle("Home Page");

        // 3. Perform login
        homePage.login();

        // 4. Assert Username is logged in
        homePage.assertUsernameLoggedIn("ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        homePage.openDifferentElementsPageThroughServiceMenu();

        // 6. Select checkboxes
        differentElementsPage.selectCheckboxes();

        // 7. Select radio
        differentElementsPage.selectRadio();

        // 8. Select in dropdown
        differentElementsPage.selectInDropdown();

        // 9. Assert that:
        // a) for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        // b)  radio button there is a log row and value is corresponded to the status of radio button
        // c) dropdown there is a log row and value is corresponded to the selected value.
        differentElementsPage.assertLog(LOG_EXPECTED_TEXT);

        softAssertions.assertAll();
    }
}
