package com.epam.tc.hw7.ex1.pages;

import static com.epam.jdi.light.elements.init.UIFactory.$;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.tc.hw7.ex1.TestData;
import java.util.Arrays;
import java.util.List;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalColorPage extends WebPage {


    @JDropdown(root = "div[ui=combobox]", value = ".filter-option", //coz just @Dropdown does not work for some reason
               list = "li", expand = ".caret")
    public static Dropdown metals;

    @JDropdown(root = "div[ui=droplist]", value = "button", list = "li", expand = ".caret")
    public static Dropdown saladDropdown;

    public void selectSalad(List<String> salads) {
        saladDropdown.select("Vegetables");
        salads.stream().forEach(salad -> saladDropdown.select(salad));
    }

    public void selectMetals(String metalSet) {
        metals.select(metalSet);
    }

    public void fillForm(TestData testData) {
        $(String.format("//label[normalize-space()='%s']", testData.getSummary().get(0))).click();
        $(String.format("//label[normalize-space()='%s']", testData.getSummary().get(1))).click();
        testData.getElements().stream()
                .forEach(element -> ($(String.format("//label[normalize-space()='%s']", element))).click());
        $("//div[@id='colors']/div/button/span").click();
        $(String.format("//a[contains(.,'%s')]", testData.getColor())).click();
        selectMetals(testData.getMetals());
        selectSalad(testData.getVegetables());
        $("#submit-button").click();
    }

    public String getActualResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : Arrays.asList(".summ-res", ".elem-res", ".col-res", ".met-res", ".sal-res")) {
            stringBuilder.append($(s).getText()).append(", ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }
}
