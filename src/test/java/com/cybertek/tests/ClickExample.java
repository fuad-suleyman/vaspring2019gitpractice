package com.cybertek.tests;

import com.cybertek.utilities.VerificationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickExample {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //WebElement inputEmail=driver.findElement(By.name("email"));
        WebElement retrieveButton=driver.findElement(By.id("form_submit"));
        Thread.sleep(1000);
        retrieveButton.click();

        String expectedUrl="http://practice.cybertekschool.com/forgot_password";
        String url= driver.getCurrentUrl();

        VerificationUtils.verifyEquals(expectedUrl,url);


    }
}
