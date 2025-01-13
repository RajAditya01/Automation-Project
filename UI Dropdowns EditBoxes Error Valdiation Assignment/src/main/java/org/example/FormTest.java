package org.example;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class base {

    public static void main(String[] args) throws InterruptedException {
        // Set the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Products to add to cart
        String[] itemsNeeded = {"Cucumber", "Broccoli", "Beetroot"};

        try {
            // Open the website
            driver.get("https://rahulshettyacademy.com/seleniumPractise/");

            // Wait for the page to load completely
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4.product-name")));

            // Add items to cart
            addItems(driver, itemsNeeded);

        } finally {
            // Close the browser
            driver.quit();
        }
    }

    public static void addItems(WebDriver driver, String[] itemsNeeded) {
        int itemsAdded = 0;

        // Get all product elements on the page
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {
            // Extract product name and format it to remove additional text
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();

            // Convert the array to a list for easy search
            List<String> itemsNeededList = Arrays.asList(itemsNeeded);

            // Check if the current product is in the list of items to add
            if (itemsNeededList.contains(formattedName)) {
                itemsAdded++;

                // Click on the "Add to Cart" button for the matched product
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                // Exit loop if all required items are added
                if (itemsAdded == itemsNeeded.length) {
                    break;
                }
            }
        }
    }
}
