package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw1.CalculatorTesting;
import com.epam.tc.hw1.data.TestData;
import org.testng.annotations.Test;


public class SubOperationTest extends CalculatorTesting {

    @Test(dataProvider = "testData", dataProviderClass = TestData.class, groups = "first")
    public void subTest(long a, long b, long sum, long sub, long multiply, long div) {
        assertThat(calculator.sub(a, b)).as("Ups, calculation was wrong").isEqualTo(sub);
    }

}
