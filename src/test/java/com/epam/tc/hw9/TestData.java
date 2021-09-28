package com.epam.tc.hw9;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider
    public static Object[][] testData() {
        return new Object[][] {{"Name"}, {"New name"}, {"Second name"}};
    }
}
