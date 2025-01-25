package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AllInOne {
    public static void main(String[] args) {
        // Set the path for ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set up an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Navigate to the website
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");

            Thread.sleep(2000);
            WebElement radioButton1 = driver.findElement(By.xpath("//input[@value='radio1']"));
//            Thread.sleep(5000);
//            WebElement radioButton2 = driver.findElement(By.xpath("//label[@for='radio1']"));
//            Thread.sleep(5000);
//            WebElement radioButton3 = driver.findElement(By.xpath("//input[@value='radio3']"));

            radioButton1.click();
//            System.out.println("Radio Button 1 is selected.");

        } catch (Exception e) {
            // Handle exceptions
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            // Ensure the browser is closed
            // driver.quit();
        }
    }
}
