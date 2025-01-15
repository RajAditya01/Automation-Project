package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class App {
    public static void main(String[] args) {
        // Setting up WebDriver for Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");

        // Initializing WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Amazon India website
            driver.get("https://www.amazon.in/");

            // Create an Actions object
            Actions actions = new Actions(driver);

            // Move to the search box element
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            actions.moveToElement(searchBox).perform();

            // Move to the account list menu element
            WebElement accountList = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
            actions.moveToElement(accountList).perform();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
//            driver.quit();
        }
    }
}
