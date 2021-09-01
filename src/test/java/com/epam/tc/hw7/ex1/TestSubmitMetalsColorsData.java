package com.epam.tc.hw7.ex1;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.tc.hw7.AbstractBaseTest;
import com.epam.tc.hw7.ex1.pages.MetalColorPage;
import org.testng.annotations.Test;

public class TestSubmitMetalsColorsData extends AbstractBaseTest {
    MetalColorPage metalColorPage = new MetalColorPage();

    @Test(dataProvider = "provideTestData", dataProviderClass = TestData.class)
    public void jdiTestEx1(TestData testData) {
        metalColorPage.fillForm(testData);
        assertThat(metalColorPage.getActualResult()).isEqualTo(testData.toString());
        WebPage.refresh();
    }

}
