package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.List;

public class AutomationTest {
    public static void main(String[] args) {
        // Setup WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

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

            //Read the data from excel
            String excelFilePath = "C:\\Users\\adity\\OneDrive\\Documents\\TestData.xlsx"; // Path to your Excel file
            // Open Excel file
            FileInputStream fis = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            // Navigate to the website
            driver.get("https://demoqa.com");
            Thread.sleep(2000);

            // Click on 'Elements'
            driver.findElement(By.xpath("//div[@class='category-cards']//div[1]//div[1]//div[2]//*[name()='svg']")).click();
            Thread.sleep(2000);

            // Select 'Text Box'
            WebElement TextBox = driver.findElement(By.xpath("//div[contains(@class,'element-list collapse show')]//li[@id='item-0']"));
            TextBox.click();
            Thread.sleep(1000);

            // Iterate through rows in Excel (skip header row)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                String userName = row.getCell(0).getStringCellValue();
                String userEmail = row.getCell(1).getStringCellValue();
                String currentAddress = row.getCell(2).getStringCellValue();
                String permanentAddress = row.getCell(3).getStringCellValue();

                // Fill out the form
                driver.findElement(By.id("userName")).clear();
                driver.findElement(By.id("userName")).sendKeys(userName);

                driver.findElement(By.id("userEmail")).clear();
                driver.findElement(By.id("userEmail")).sendKeys(userEmail);

                driver.findElement(By.id("currentAddress")).clear();
                driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);

                driver.findElement(By.id("permanentAddress")).clear();
                driver.findElement(By.id("permanentAddress")).sendKeys(permanentAddress);

                // Submit the form
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,500)");
                driver.findElement(By.id("submit")).click();
                Thread.sleep(1000);

                // Verify the output
                String actualName = driver.findElement(By.id("name")).getText().replace("Name:", "").trim();
                String actualEmail = driver.findElement(By.id("email")).getText().replace("Email:", "").trim();
                String actualCurrentAddress = driver.findElement(By.id("currentAddress")).getText().replace("Current Address :", "").trim();
                String actualPermanentAddress = driver.findElement(By.id("permanentAddress")).getText().replace("Permananet Address :", "").trim();

                boolean isPass = userName.equals(actualName) &&
                        userEmail.equals(actualEmail) &&
                        currentAddress.equals(actualCurrentAddress) &&
                        permanentAddress.equals(actualPermanentAddress);

                // Write result to Excel
                Cell resultCell = row.createCell(4);
                resultCell.setCellValue(isPass ? "Pass" : "Fail");
            }



//            // Enter details and submit the form
//            driver.findElement(By.id("userName")).sendKeys("Aditya");
//            driver.findElement(By.id("userEmail")).sendKeys("adityavishal903@gmail.com");
//            driver.findElement(By.id("currentAddress")).sendKeys("KoperKharne Navi Mumbai");
//            driver.findElement(By.id("permanentAddress")).sendKeys("Muzaffarpur");
//
//            // Scroll down by 500 pixels
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("window.scrollBy(0,500)");
//
//            driver.findElement(By.id("submit")).click();
//            driver.findElement(By.xpath("//button[@id='submit']")).click();

            Thread.sleep(2000);

            // Expected values
            String expectedName = "Name:Aditya";
            String expectedEmail = "Email:adityavishal903@gmail.com";
            String expectedCurrentAddress = "Current Address :KoperKharne Navi Mumbai";
            String expectedPermanentAddress = "Permananet Address :Muzaffarpur Bihar";

            // Fetch the output
            WebElement outputName = driver.findElement(By.id("name"));
            WebElement outputEmail = driver.findElement(By.id("email"));
            WebElement outputCurrentAddress = driver.findElement(By.id("currentAddress"));
            WebElement outputPermanentAddress = driver.findElement(By.id("permanentAddress"));

            // Verify the output
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

            // Click on 'Alerts, Frames & Windows'
            driver.findElement(By.xpath("//div[@class='header-text' and contains(., 'Alerts, Frame & Windows')]")).click();
            Thread.sleep(2000);

            // Click on 'Frames'
            driver.findElement(By.xpath("//li[@id='item-2']//span[text()='Frames']")).click();
            Thread.sleep(2000);

            // Fetch the iframe and switch to it
            WebElement iframe = driver.findElement(By.xpath("//iframe[@id='frame1']"));
            driver.switchTo().frame(iframe);
            Thread.sleep(1000);

            // Fetch the content from the text box inside the iframe
            WebElement sampleHeading = driver.findElement(By.id("sampleHeading"));
            System.out.println("Get details from both the text box : " + sampleHeading.getText());

            // Switch back to the main content
            driver.switchTo().defaultContent();
            Thread.sleep(1000);


            // Click on 'Click me' next to the "On button click, confirm box will appear"
            driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']")).click();
            Thread.sleep(2000);

            // Click the alert button to trigger the confirm box
            driver.findElement(By.id("alertButton")).click();

            // Switching to the alert and printing its text
            System.out.println("Alert Text: " + driver.switchTo().alert().getText());

            // Accepting the alert
            driver.switchTo().alert().accept();

//  ------------------------------------------
            // #Isko fix krna hai

//            driver.findElement(By.id("timerAlertButton")).click();
//            Thread.sleep(5000);
//            System.out.println("On Button Click Alert Text :" +driver.switchTo().alert().getText());
//            // Accepting the alert
//            driver.switchTo().alert().accept();
//            Thread.sleep(2000);

//            driver.findElement(By.id("confirmButton")).click();
//            System.out.println("On Button Click Conform box will appear :" +driver.switchTo().alert().getText());
//            // Accepting the alert
//            driver.switchTo().alert().accept();
//            Thread.sleep(2000);

//            driver.findElement(By.id("promtButton")).click();
//            System.out.println("On Button Click Prompt box will appear:" +driver.switchTo().alert().getText());
//            // Accepting the alert
//            driver.switchTo().alert().accept();

//  --------------------------
            Thread.sleep(1000);
            //Click 'Browser Windows'
            driver.findElement(By.xpath("//span[normalize-space()='Browser Windows']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[@id='tabButton']")).click();

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            String newTabText = driver.findElement(By.tagName("body")).getText();
            System.out.println("New Tab Text: " + newTabText);

            driver.close();

            // Switch back to the original window
            driver.switchTo().window(driver.getWindowHandles().iterator().next());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
//            driver.quit();
        }
    }
}
