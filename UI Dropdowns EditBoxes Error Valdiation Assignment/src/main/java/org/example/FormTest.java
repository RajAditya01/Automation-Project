package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormTest {
    public static void main(String[] args) {
        // Set the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open the website
            driver.get("https://rahulshettyacademy.com/angularpractice/"); // Replace with your website URL
            driver.manage().window().maximize();

            // Pause to allow page to load
            Thread.sleep(2000);

            // **Testing Name Field**
            WebElement nameField = driver.findElement(By.name("name")); // Replace with the actual name field identifier
            nameField.clear();
            nameField.sendKeys("Aditya Raj");
            assert nameField.getAttribute("value").equals("Aditya Raj") : "Name field test failed";

            // **Testing Email Field**
            WebElement emailField = driver.findElement(By.name("email"));
            emailField.clear();
            emailField.sendKeys("adityavishal903@gmail.com");
            assert emailField.getAttribute("value").contains("@") : "Invalid email format";

            // **Testing Password Field**
            WebElement passwordField = driver.findElement(By.id("exampleInputPassword1"));
            passwordField.sendKeys("password123");
            assert passwordField.getAttribute("type").equals("password") : "Password field test failed";

            // **Testing Checkbox**
            WebElement checkbox = driver.findElement(By.id("exampleCheck1")); // Replace with the checkbox ID
            checkbox.click();
            assert checkbox.isSelected() : "Checkbox selection failed";

            // **Testing Gender Dropdown**
            WebElement genderDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
            Select select = new Select(genderDropdown);
            select.selectByVisibleText("Male"); // Select "Male"
            assert select.getFirstSelectedOption().getText().equals("Male") : "Dropdown selection test failed";

            // **Testing Radio Buttons (Employment Status)**
            WebElement studentRadio = driver.findElement(By.id("inlineRadio1"));
            studentRadio.click();
            assert studentRadio.isSelected() : "Radio button selection failed for 'Student'";

            // **Testing Disabled Radio Button**
            WebElement entrepreneurRadio = driver.findElement(By.id("inlineRadio3")); // Correct ID for entrepreneur radio button
            assert !entrepreneurRadio.isEnabled() : "Disabled radio button is clickable";

            // **Testing Date of Birth**
            WebElement dobField = driver.findElement(By.name("bday"));
            dobField.sendKeys("2003-08-11");
            assert dobField.getAttribute("value").equals("2003-08-11") : "Date of Birth field test failed";

            // **Submitting the Form**
            WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit' and @value='Submit']"));
            submitButton.click();

            // Pause to wait for the success message
            Thread.sleep(2000);

            // Locate and verify the success message
            WebElement successMessage = driver.findElement(By.cssSelector("div.alert.alert-success"));
            String messageText = successMessage.getText();

            // Assertion to validate the success message contains "Success!"
            assert messageText.contains("Success!") : "Form submission test failed";

            // Print the success message
            System.out.println("Form submission successful! Message displayed: " + messageText);


            // **Negative Test: Submit with Empty Fields**
            driver.navigate().refresh(); // Refresh the page to reset the form
            Thread.sleep(2000); // Allow page to refresh
            submitButton = driver.findElement(By.xpath("//input[@type='submit' and @value='Submit']"));
            submitButton.click();

            // Pause to wait for the error message
            Thread.sleep(2000);

            // Locate and verify the error message
            WebElement errorMessage = driver.findElement(By.className("error")); // Replace with actual class or locator for the error
            assert errorMessage.isDisplayed() : "Error message not displayed for empty fields";

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
