package org.example;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {
    public static void main(String[] args) {
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the website
        driver.get("https://rahulshettyacademy.com/client");

        // Login
        driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
        driver.findElement(By.id("login")).click();

        // Explicit wait for products to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

        // Find products
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

        // Find specific product "ZARA COAT 3"
        WebElement prod = products.stream()
                .filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3"))
                .findFirst()
                .orElse(null);

        if (prod != null) {
            // Click on Add to Cart button
            prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

            // Wait for toast notification
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

            // Wait for animation to disappear
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

            // Click on Cart
            driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
        } else {
            System.out.println("Product not found!");
        }

        // Close the browser
        driver.quit();
    }
}
