package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;

public class CalculatorTesting {
    private static Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public static Calculator initCalc() {
        return calculator = new Calculator();
    }

}
