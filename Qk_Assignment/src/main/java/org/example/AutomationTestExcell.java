package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class AutomationTestExcell {
    public static void main(String[] args) {
        // Setup WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        try {
            // Read the data from Excel
            String excelFilePath = "C:\\Users\\adity\\OneDrive\\Documents\\TestData.xlsx";
            FileInputStream fis = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            // Navigate to the website
            driver.get("https://demoqa.com");
            Thread.sleep(2000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,500)");
            // Click on 'Elements'
            driver.findElement(By.xpath("//div[@class='category-cards']//div[1]//div[1]//div[2]//*[name()='svg']")).click();
            Thread.sleep(2000);

            // Select 'Text Box'
            WebElement textBox = driver.findElement(By.xpath("//div[contains(@class,'element-list collapse show')]//li[@id='item-0']"));
            textBox.click();
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
                Cell resultCell = row.createCell(4); // Column 5 for result
                resultCell.setCellValue(isPass ? "Pass" : "Fail");
            }

            // Save the updated Excel file
            fis.close(); // Close the input stream
            FileOutputStream fos = new FileOutputStream(excelFilePath);
            workbook.write(fos);
            fos.close();
            workbook.close();

            System.out.println("Test results written to Excel successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // driver.quit();
        }
    }
}
