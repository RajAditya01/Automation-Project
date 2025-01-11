package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

    public static void main(String[] args) {

        // Set the path for the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the practice site
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        // Fill in the form fields
        driver.findElement(By.name("name")).sendKeys("Aditya Raj");
        driver.findElement(By.name("email")).sendKeys("hello@abc.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("123456");

        // Click on the checkbox
        driver.findElement(By.id("exampleCheck1")).click();

        // Handle the dropdown
        WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
        Select abc = new Select(dropdown);
        abc.selectByVisibleText("Female");

        // Select the radio button
        driver.findElement(By.id("inlineRadio1")).click();

        // Enter the date of birth
        driver.findElement(By.name("bday")).sendKeys("02/02/1992");

        // Submit the form
        driver.findElement(By.cssSelector(".btn-success")).click();

        // Print the success message
        System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());

        // Close the browser
        driver.quit();
    }
}
