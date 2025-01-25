package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutomationAssignment {
    public static void main(String[] args) {
        // Setup WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Navigate to the website
            driver.get("https://demoqa.com");
            Thread.sleep(2000);

            // Click on 'Elements'
            driver.findElement(By.xpath("//div[@class='category-cards']//div[1]//div[1]//div[2]//*[name()='svg']")).click();
            Thread.sleep(2000);

            // Get list of items under Elements
            List<WebElement> items = driver.findElements(By.cssSelector(".element-group .menu-list li"));
            System.out.println("Items under Elements:");
            for (WebElement item : items) {
                System.out.println(item.getText());
            }

            // Select 'Text Box' using XPath
            WebElement textBox = driver.findElement(By.xpath("//div[contains(@class,'element-list collapse show')]//li[@id='item-0']"));
            textBox.click();
            Thread.sleep(1000);

            // Enter details and submit the form
            driver.findElement(By.id("userName")).sendKeys("Aditya");
            driver.findElement(By.id("userEmail")).sendKeys("adityavishal903@gmail.com");
            driver.findElement(By.id("currentAddress")).sendKeys("KoperKharne Navi Mumbai");
            driver.findElement(By.id("permanentAddress")).sendKeys("Muzaffarpur Bihar");

            // Wait for the submit button to be clickable
            WebElement submitButton = driver.findElement(By.id("submit"));
            try {
                wait.until(ExpectedConditions.elementToBeClickable(submitButton));
                submitButton.click();
            } catch (ElementClickInterceptedException e) {
                System.out.println("Submit button was blocked. Attempting JavaScript click.");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
            }

            Thread.sleep(2000);

            // Verify output
            String expectedName = "Name:Aditya";
            String expectedEmail = "Email:adityavishal903@gmail.com";
            String expectedCurrentAddress = "Current Address :KoperKharne Navi Mumbai";
            String expectedPermanentAddress = "Permananet Address :Muzaffarpur Bihar";

            WebElement outputName = driver.findElement(By.id("name"));
            WebElement outputEmail = driver.findElement(By.id("email"));
            WebElement outputCurrentAddress = driver.findElement(By.id("currentAddress"));
            WebElement outputPermanentAddress = driver.findElement(By.id("permanentAddress"));

            if (outputName.getText().equals(expectedName)) {
                System.out.println("Name verified successfully!");
            } else {
                System.out.println("Name verification failed! Expected: " + expectedName + ", Found: " + outputName.getText());
            }

            if (outputEmail.getText().equals(expectedEmail)) {
                System.out.println("Email verified successfully!");
            } else {
                System.out.println("Email verification failed! Expected: " + expectedEmail + ", Found: " + outputEmail.getText());
            }

            if (outputCurrentAddress.getText().equals(expectedCurrentAddress)) {
                System.out.println("Current Address verified successfully!");
            } else {
                System.out.println("Current Address verification failed! Expected: " + expectedCurrentAddress + ", Found: " + outputCurrentAddress.getText());
            }

            if (outputPermanentAddress.getText().equals(expectedPermanentAddress)) {
                System.out.println("Permanent Address verified successfully!");
            } else {
                System.out.println("Permanent Address verification failed! Expected: " + expectedPermanentAddress + ", Found: " + outputPermanentAddress.getText());
            }

            Thread.sleep(2000);

            // Handle iframe in 'Frames' section
            driver.findElement(By.xpath("//div[@class='header-text' and contains(., 'Alerts, Frame & Windows')]")).click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//li[@id='item-2']//span[text()='Frames']")).click();
            Thread.sleep(2000);

            WebElement iframe = driver.findElement(By.id("frame1"));
            driver.switchTo().frame(iframe);
            WebElement sampleHeading = driver.findElement(By.id("sampleHeading"));
            System.out.println("Text inside iframe: " + sampleHeading.getText());

            driver.switchTo().defaultContent();
            Thread.sleep(1000);

            // Handle alert actions
            driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']")).click();
            Thread.sleep(2000);

            driver.findElement(By.id("alertButton")).click();
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert Text: " + alert.getText());
            alert.accept();

            // Add further actions as required...

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
