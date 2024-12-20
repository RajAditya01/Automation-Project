package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage {
    private WebDriver driver;
    private By inputField = By.id("number");

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterNumber(String number) {
        driver.findElement(inputField).sendKeys(number);
    }

    public String getInputValue() {
        return driver.findElement(inputField).getAttribute("value");
    }
}
