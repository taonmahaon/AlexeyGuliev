package com.epam.tc.hw5.steps;

import io.cucumber.java.en.When;

public class ActionStep extends AbstractStep {

    @When("I login as user 'Roman Iovlev'")
    public void login() {
        differentElementsPage.login();
    }

    @When("I open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPage() {
        differentElementsPage.openDifferentElementsPageThroughServiceMenu();
    }

    @When("I select checkboxes")
    public void selectCheckboxes() {
        differentElementsPage.selectCheckboxes();
    }

    @When("I select 'Selen' radio")
    public void selectRadio() {
        differentElementsPage.selectRadio();
    }

    @When("I select 'Yellow' in dropdown")
    public void selectDropdown() {
        differentElementsPage.selectInDropdown();
    }

    @When("I click on 'Service' button in Header")
    public void clickServiceButton() {
        differentElementsPage.clickServiceButton();
    }

    @When("I click on 'User Table' button in Service dropdown")
    public void  clickUserTableLink() {
        differentElementsPage.clickUserTable();
    }

    @When("I select 'vip' checkbox for 'Sergey Ivan'")
    public void clickVipCheckboxForSergeyIvan() {
        userTablePage.clickIvanVipCheckbox();
    }
}
