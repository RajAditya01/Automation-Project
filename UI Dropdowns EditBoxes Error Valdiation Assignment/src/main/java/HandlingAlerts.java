import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {
    public static void main(String[] args) {

        // Defining name for input
        String name = "Aditya";

        // Setting up WebDriver for Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");

        // Initializing WebDriver
        WebDriver driver = new ChromeDriver();

        // Opening the target website
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Entering text in the name field
        driver.findElement(By.id("name")).sendKeys(name);

        // Clicking the alert button to trigger an alert
        driver.findElement(By.cssSelector("[id='alertbtn']")).click();

        // Switching to the alert and printing its text
        System.out.println("Alert Text: " + driver.switchTo().alert().getText());

        // Accepting the alert
        driver.switchTo().alert().accept();

        // Clicking the confirm button to trigger a confirmation alert
        driver.findElement(By.id("confirmbtn")).click();

        // Switching to the confirmation alert and printing its text
        System.out.println("Confirm Alert Text: " + driver.switchTo().alert().getText());

        // Dismissing the confirmation alert
        driver.switchTo().alert().dismiss();

        // Closing the browser
        driver.quit();
    }
}
