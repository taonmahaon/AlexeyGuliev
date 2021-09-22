package com.epam.tc.hw7.sites.pages;

import static com.epam.jdi.light.elements.init.UIFactory.$;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.utils.JsonAsDataProvider;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalColorPage extends WebPage {

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

    public void fillForm(JsonAsDataProvider testData) {
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

    public String getActualResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : Arrays.asList(".summ-res", ".elem-res", ".col-res", ".met-res", ".sal-res")) {
            stringBuilder.append($(s).getText()).append(", ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }
}
