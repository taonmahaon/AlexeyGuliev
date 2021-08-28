package com.epam.tc.hw6.ex1;

import static com.epam.tc.hw4.Constants.BENEFIT_EXPECTED_TEXT;
import static com.epam.tc.hw4.Constants.HEADER_EXPECTED_TEXT;
import static com.epam.tc.hw4.Constants.SIDEBAR_EXPECTED_TEXTS;
import static com.epam.tc.hw4.Constants.URL;

import com.epam.tc.hw6.AbstractBaseTest;
import com.epam.tc.hw6.pages.HomePage;
import com.epam.tc.hw6.steps.BaseJdiTestingPageSteps;
import com.epam.tc.hw6.steps.HomePageSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Home Page")
@Story("Checking the operation of homepage components")
public class JdiTestingEx1 extends AbstractBaseTest {
    @Test(description = "Homework_4 Ex1 \"Test with Allure and all this stuff\"")
    @Description("Assertions that homepage works as expected")
    public void softAssertsTestEx1() {

        final HomePageSteps homePageSteps = new HomePageSteps(webDriver, wait);
        final HomePage homePage = new HomePage(webDriver, wait);
        final BaseJdiTestingPageSteps baseJdiTestingPageSteps = new BaseJdiTestingPageSteps(webDriver, wait);

        // 1. Open test site by URL
        homePage.openSiteByUrl(URL);

        // 2. Assert Browser title
        baseJdiTestingPageSteps.assertBrowserTitle("Home Page");

        // 3. Perform login
        homePage.login();

        // 4. Assert Username is logged in
        baseJdiTestingPageSteps.assertUsernameLoggedIn("ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        baseJdiTestingPageSteps.assertHeaderSection(4, HEADER_EXPECTED_TEXT);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        homePageSteps.assertBenefitImages(4);

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePageSteps.assertBenefitTexts(BENEFIT_EXPECTED_TEXT);

        // 8. Assert that there is the iframe with “Frame Button” exist
        homePageSteps.assertFrameExist();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        homePageSteps.assertButtonExist();

        // 10. Switch to original window back
        homePage.switchToOriginalWindow();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        baseJdiTestingPageSteps.assertLeftMenu(5, SIDEBAR_EXPECTED_TEXTS);

    }
}
