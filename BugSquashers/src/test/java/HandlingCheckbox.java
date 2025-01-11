import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandlingCheckbox {

    public static void main(String[] args) {
        // Set up the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Navigate to the URL
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Verify the checkbox is not selected by default
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        System.out.println("Checkbox initially selected: " +
                driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        // Click the checkbox
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        // Verify the checkbox is now selected
        System.out.println("Checkbox after click selected: " +
                driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        // Close the browser
        driver.quit();
    }
}
