package com.epam.tc.hw7.sites.pages;

import static com.epam.jdi.light.elements.init.UIFactory.$;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.tc.hw7.sites.forms.MetalColorForm;
import java.util.Arrays;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalColorPage extends WebPage {
    @Css("form")
    public static MetalColorForm metalColorForm;

    public String getActualResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : Arrays.asList(".summ-res", ".elem-res", ".col-res", ".met-res", ".sal-res")) {
            stringBuilder.append($(s).getText()).append(", ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }
}
