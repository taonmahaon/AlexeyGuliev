package com.epam.tc.hw7.tests;

import static com.epam.tc.hw7.sites.JdiTestingSite.metalColorPage;
import static com.epam.tc.hw7.sites.pages.HomePage.headerMenu;
import static com.epam.tc.hw7.sites.pages.MetalColorPage.metalColorForm;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.tc.hw7.entities.MetalColor;
import com.epam.tc.hw7.utils.DataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestSubmitMetalsColorsData extends BaseTest {
    @Test(dataProvider = "provideTestData", dataProviderClass = DataProvider.class)
    public void jdiTestEx1(MetalColor testData) {
        headerMenu.select("Metals & Colors");
        metalColorPage.checkOpened();
        metalColorForm.submit(testData);
        assertThat(metalColorPage.getActualResult()).isEqualTo(testData.toString());
    }

    @AfterTest
    public void refresh() {
        WebPage.refresh();
    }
}
