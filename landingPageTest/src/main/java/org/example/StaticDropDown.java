package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {
    public static void main(String[] args) {

        // Set the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the website
            driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


        // Locate the dropdown with a select tag
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        // Initialize the Select class
        Select dropdown = new Select(staticDropdown);

        // Select an option by index
        dropdown.selectByIndex(3);

        // Print the selected option
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByValue("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        // Close the browser
        driver.quit();
    }
}
