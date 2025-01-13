import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class base {
    public static void main(String[] args) {
        // Set the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Products to search for
        String[] names = {"Cucumber", "Broccoli"};
        List<String> itemsNeeded = Arrays.asList(names);

        try {
            // Open the website
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

            // Get the list of products displayed on the page
            List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

            // Loop through products
            for (int i = 0; i < products.size(); i++) {
                // Extract the product name and trim additional text (e.g., "- 1 Kg")
                String productName = products.get(i).getText().split("-")[0].trim();

                // Check if the product is in the list of items needed
                if (itemsNeeded.contains(productName)) {
                    // Find the corresponding "ADD TO CART" button and click
                    driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                    // If all items are found, exit the loop
                    if (itemsNeeded.size() == 1) break;
                }
            }
        } finally {
            // Close the driver
            driver.quit();
        }
    }
}
