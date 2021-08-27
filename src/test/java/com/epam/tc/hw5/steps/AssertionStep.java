package com.epam.tc.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw4.utils.GetPropertyFile;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class AssertionStep extends AbstractStep {

    @Then("user 'Roman Iovlev' logged in")
    public void assertUsernameLoggedIn() {
        assertThat(differentElementsPage.getUserName())
            .isEqualTo(GetPropertyFile.getProperty().getProperty("fullName"));
    }

    @Then("'Water' and 'Wind' elements checked")
    public void assertCheckboxesChecked() {
        assertThat(differentElementsPage.assertCheckboxesChecked()).isTrue();
    }

    @Then("'Selen' element checked")
    public void assertRadioChecked() {
        differentElementsPage.assertRadioChecked();
    }

    @Then("'Yellow' element selected")
    public void assertDropdownChecked() {
        differentElementsPage.assertYellowDropdownChecked();
    }

    @Then("log rows are displayed, with values corresponding to the selected")
    public void assertLog() {
        differentElementsPage.assertLog();
    }

    @Then("'User Table' page should be opened")
    public void assertUserTablePageTitle() {
        userTablePage.assertUserTablePageTitle();
    }

    @Then("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void assertUserTableDropdowns() {
        userTablePage.assertUserTableDropdowns();
    }

    @Then("6 Usernames should be displayed on Users Table on User Table Page")
    public void assertUserNames() {
        userTablePage.assertUserNames();
    }

    @Then("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void assertUserDescription() {
        userTablePage.assertUserDescription();
    }

    @Then("6 checkboxes should be displayed on Users Table on User Table Page")
    public void assertCheckboxes() {
        userTablePage.assertCheckboxes();
    }

    @Then("User table should contain following values:")
    public void assertUserTableContainProperValues(DataTable dataTable) {
        userTablePage.assertTableText(dataTable);
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void assertDropdownContainProperValuesForUserRoman(DataTable dataTable) {
        userTablePage.assertRomanDropdown(dataTable);
    }

    @Then("1 log row has {string} text in the row section")
    public void assertLogRowHasProperText(String properText) {
        baseJdiTestingPage.assertLogContainProperText(properText);
    }
}
