package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxPage {
    private WebDriver driver;
    private By firstCheckbox = By.cssSelector("input[type='checkbox']:nth-child(1)");
    private By secondCheckbox = By.cssSelector("input[type='checkbox']:nth-child(2)");

    public CheckboxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkFirstCheckbox() {
        if (!driver.findElement(firstCheckbox).isSelected()) {
            driver.findElement(firstCheckbox).click();
        }
    }

    public void uncheckSecondCheckbox() {
        if (driver.findElement(secondCheckbox).isSelected()) {
            driver.findElement(secondCheckbox).click();
        }
    }

    public boolean isFirstCheckboxChecked() {
        return driver.findElement(firstCheckbox).isSelected();
    }

    public boolean isSecondCheckboxChecked() {
        return driver.findElement(secondCheckbox).isSelected();
    }
}
