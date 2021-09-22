package com.epam.tc.hw7.tests;

import static com.epam.tc.hw7.sites.JdiTestingSite.metalColorPage;
import static com.epam.tc.hw7.sites.pages.HomePage.headerMenu;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.tc.hw7.utils.JsonAsDataProvider;
import org.testng.annotations.Test;

public class TestSubmitMetalsColorsData extends AbstractBaseTest {


    @Test(dataProvider = "provideTestData", dataProviderClass = JsonAsDataProvider.class)
    public void jdiTestEx1(JsonAsDataProvider testData) {
        headerMenu.select("Metals & Colors");
        metalColorPage.checkOpened();
        metalColorPage.fillForm(testData);
        assertThat(metalColorPage.getActualResult()).isEqualTo(testData.toString());
        WebPage.refresh();
    }

}
