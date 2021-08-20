package com.epam.tc.hw3.ex2;

import static com.epam.tc.hw3.Constants.LOG_EXPECTED_TEXT;
import static com.epam.tc.hw3.Constants.URL;

import com.epam.tc.hw3.AbstractBaseTest;
import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.steps.BaseJdiTestingPageSteps;
import com.epam.tc.hw3.steps.DifferentElementsPageSteps;
import org.testng.annotations.Test;

public class JdiTestingEx2 extends AbstractBaseTest {

    @Test
    public void interactiveElementsTestEx2() {

        final DifferentElementsPage differentElementsPage = new DifferentElementsPage(webDriver, wait);
        final DifferentElementsPageSteps differentElementsPageSteps = new DifferentElementsPageSteps(webDriver, wait);
        final BaseJdiTestingPageSteps baseJdiTestingPageSteps = new BaseJdiTestingPageSteps(webDriver, wait);

        // 1. Open test site by URL
        differentElementsPage.openSiteByUrl(URL);

        // 2. Assert Browser title
        baseJdiTestingPageSteps.assertBrowserTitle("Home Page");

        // 3. Perform login
        differentElementsPage.login();

        // 4. Assert Username is logged in
        baseJdiTestingPageSteps.assertUsernameLoggedIn("ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        differentElementsPage.openDifferentElementsPageThroughServiceMenu();

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
        differentElementsPageSteps.assertLog(LOG_EXPECTED_TEXT);

        softAssertions.assertAll();
    }
}
