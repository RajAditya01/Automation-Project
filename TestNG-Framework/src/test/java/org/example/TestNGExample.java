package org.example;

import org.testng.annotations.*;

public class TestNGExample {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite: Setting up preconditions for the test suite.");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite: Cleaning up after all tests are done.");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method: Running preconditions before each test.");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method: Running postconditions after each test.");
    }

    @Test
    public void testCase1() {
        System.out.println("Test Case 1: Running actual test logic.");
    }

    @Test
    public void testCase2() {
        System.out.println("Test Case 2: Running another test.");
    }
}
