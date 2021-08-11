package com.epam.tc.hw1.data;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider
    public static Object [][] testData() {
        return new Object[][] {{1, 2, 3, -1, 2, 0}, {14, 7, 21, 7, 98, 2}, {8, 1, 9, 7, 8, 8}, {12, 3, 15, 9, 36, 4}};
    }
}
