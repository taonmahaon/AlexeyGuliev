package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw1.data.TestData;
import org.testng.annotations.Test;

public class DivideOperationTest extends CalculatorTesting {

    @Test(dataProvider = "testData", dataProviderClass = TestData.class, groups = "second")
    public void divTest(long a, long b, long sum, long sub, long multiply, long div) {
        assertThat(calculator.div(a, b)).as("Ups, calculation was wrong").isEqualTo(div);
    }

}
