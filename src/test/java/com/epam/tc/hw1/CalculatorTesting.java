package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;

public class CalculatorTesting {
    protected Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void initCalc() {
        calculator = new Calculator();
    }

}
