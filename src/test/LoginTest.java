package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        loginPage.enterUsername("aditya");
        loginPage.enterPassword("Aditya@321");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.getSuccessMessage().contains("You logged into a secure area!"));
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
