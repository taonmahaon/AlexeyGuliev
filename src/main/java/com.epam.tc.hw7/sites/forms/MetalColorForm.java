package com.epam.tc.hw7.sites.forms;

import static com.epam.jdi.light.elements.init.UIFactory.$;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.entities.MetalColor;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;

public class MetalColorForm extends Form<MetalColor> {
    @UI("[name=custom_radio_even]")
    public static RadioButtons evenSummary;

    @UI("[name=custom_radio_odd]")
    public static RadioButtons oddSummary;

    @JDropdown(root = "div[ui=combobox]", value = ".filter-option", //coz just @Dropdown does not work for some reason
               list = "li", expand = ".caret")
    public static Dropdown metals;

    @JDropdown(root = "div[ui=droplist]", value = "button", list = "li", expand = ".caret")
    public static Dropdown saladDropdown;

    @JDropdown(root = "div[ui=dropdown]",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public static Dropdown colors;

    @FindBy(id = "submit-button")
    public static WebElement submitButton;

    public void selectSalad(List<String> salads) {
        saladDropdown.select("Vegetables");
        salads.stream().forEach(salad -> saladDropdown.select(salad));
    }

    public void selectMetals(String metalSet) {
        metals.select(metalSet);
    }

    @Override
    public void submit(MetalColor testData) {
        oddSummary.select(testData.getSummary().get(0).toString());
        evenSummary.select(testData.getSummary().get(1).toString());
        testData.getElements().stream()
                .forEach(element -> ($(String.format("//label[normalize-space()='%s']", element))).click());
        colors.expand();
        colors.select(testData.getColor());
        selectMetals(testData.getMetals());
        selectSalad(testData.getVegetables());
        submitButton.click();
    }
}
