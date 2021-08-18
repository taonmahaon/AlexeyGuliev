package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.TestDataHw3;
import com.epam.tc.hw3.pages.HomePage;
import org.testng.annotations.Test;

public class JdiTestingEx1 extends TestDataHw3 {
    @Test
    public void softAssertsTestEx1() {

        final HomePage homePage = new HomePage(webDriver, wait, softAssertions);

        // 1. Open test site by URL
        homePage.openSiteByUrl(URL);

        // 2. Assert Browser title
        homePage.assertBrowserTitle("Home Page");

        // 3. Perform login
        homePage.login();

        // 4. Assert Username is logged in
        homePage.assertUsernameLoggedIn("ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.assertHeaderSection(4, HEADER_EXPECTED_TEXT);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        homePage.assertBenefitImages(4);

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.assertBenefitTexts(BENEFIT_EXPECTED_TEXT);

        // 8. Assert that there is the iframe with “Frame Button” exist
        homePage.assertFrameExist();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        homePage.assertButtonExist();

        // 10. Switch to original window back
        homePage.switchToOriginalWindow();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        homePage.assertLeftMenu(5, SIDEBAR_EXPECTED_TEXTS);

        softAssertions.assertAll();
    }
}
