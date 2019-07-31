package com.cybertek.tests;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SentKeysExample {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        Thread.sleep(3000);
        WebElement emailInput=driver.findElement(By.name("email"));

        // sendKeys()==>enter text on webelement
        emailInput.sendKeys("fuad@gmail.com");

        WebElement retrieveClick=driver.findElement(By.id("form_submit"));
        retrieveClick.click();

        String expected="http://practice.cybertekschool.com/forgot_password";
        String actual=driver.getCurrentUrl();
        VerificationUtils.verifyEquals(expected,actual);

        driver.close();

    }
}
