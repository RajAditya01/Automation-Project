package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    //constructor
    LoginPage(WebDriver d){
        driver = d;
    }

    //identify webElement
    //create methods of operation to be performed on Web Elements
    By username =By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");
}

public void enterUsernam(String uname){
    driver.findElement(username).sendKeys("standard_user");
}

public void password(String uname){
    driver.findElement(password).sendKeys("secret_sauce");
}
