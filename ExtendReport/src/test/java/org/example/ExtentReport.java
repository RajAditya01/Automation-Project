package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReport {
    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void setup() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Test
    public void sampleTest() {
        test = extent.createTest("Sample Test");
        test.info("Starting the test case...");
        Assert.assertTrue(true);
        test.pass("Test case passed successfully!");
    }

    @AfterTest
    public void tearDown() {
        extent.flush();
    }
}
