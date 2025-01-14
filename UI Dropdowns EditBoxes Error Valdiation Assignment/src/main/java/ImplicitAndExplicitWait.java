import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitAndExplicitWait {
    public static void main(String[] args) {

        // Set the path to the WebDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // WebDriverWait with Duration (Selenium 4.x)
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Items to be added to the cart
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};

        // Open the URL
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        // Add items to the cart
        addItems(driver, itemsNeeded);

        // Click on the cart icon
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();

        // Click on Proceed to Checkout
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        // Wait for promo code input to be visible
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

        // Enter promo code
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

        // Click on Apply button
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        // Wait for promo info message to be visible
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        // Print the promo info message
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

        // Close the browser
        driver.quit();
    }

    // Method to add items to the cart
    public static void addItems(WebDriver driver, String[] itemsNeeded) {

        int j = 0;

        // Get the list of product names
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        // Loop through the products and add them to the cart if they match
        for (int i = 0; i < products.size(); i++) {
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim(); // Extract product name

            // Convert array into a list for easy search
            List<String> itemsNeededList = Arrays.asList(itemsNeeded);

            // Check if the item is in the list and add it to the cart
            if (itemsNeededList.contains(formattedName)) {
                j++;
                // Click on "Add to cart" button
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                // Break if all items are added to the cart
                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }
    }
}
