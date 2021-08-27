package com.epam.tc.hw5.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/com/epam/tc/hw5/cucumber/ex1.feature",
    "src/test/resources/com/epam/tc/hw5/cucumber/ex2.feature",
    "src/test/resources/com/epam/tc/hw5/cucumber/ex3.feature"},
                 glue = {"com/epam/tc/hw5/steps", "com/epam/tc/hw5/cucumber/hooks"}) //coz didn't work by default -_-
public class RunTest extends AbstractTestNGCucumberTests {


}
