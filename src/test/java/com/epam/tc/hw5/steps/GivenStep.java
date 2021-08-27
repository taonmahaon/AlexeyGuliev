package com.epam.tc.hw5.steps;

import static com.epam.tc.hw5.Constants.HOME_PAGE_TITLE;
import static com.epam.tc.hw5.Constants.URL;
import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;

public class GivenStep extends AbstractStep {

    @Given("I open JDI-testing site")
    public void openSite() {
        differentElementsPage.openSiteByUrl(URL);
        assertThat(differentElementsPage.getPageTitle()).isEqualTo(HOME_PAGE_TITLE);
    }


}
