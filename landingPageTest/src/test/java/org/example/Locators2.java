package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.junit.Assert; // Import JUnit

import java.time.Duration;

public class Locators2 {

    public static void main(String[] args) throws InterruptedException {

        String name = "aditya";

        System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String password = getPassword(driver);

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();

        Thread.sleep(2000);

        String loginMessage = driver.findElement(By.tagName("p")).getText();
        System.out.println(loginMessage);
        Assert.assertEquals("Login success message mismatch", "You are successfully logged in.", loginMessage);

        String welcomeMessage = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
        Assert.assertEquals("Welcome message mismatch", "Hello " + name + ",", welcomeMessage);

        driver.findElement(By.xpath("//*[text()='Log Out']")).click();

        driver.close();
    }

    public static String getPassword(WebDriver driver) throws InterruptedException {

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();

        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        String passwordText = driver.findElement(By.cssSelector("form p")).getText();
        System.out.println("Password message: " + passwordText);

        String[] passwordArray = passwordText.split("'");
        String password = passwordArray[1].split("'")[0];
        System.out.println("Extracted Password: " + password);

        return password;
    }
}
