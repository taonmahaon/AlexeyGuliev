package com.epam.tc.hw4.listeners;

import com.epam.tc.hw4.utils.AttachmentUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        var driver = result.getTestContext().getAttribute("driver");

        if (driver != null) {
            AttachmentUtil.makeScreenshotAttachment("place of issue",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        }
    }
}
