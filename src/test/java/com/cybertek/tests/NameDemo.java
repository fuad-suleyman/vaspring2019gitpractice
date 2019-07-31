package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NameDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();


        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement name=driver.findElement(By.name("full_name"));

        Thread.sleep(1500);
        name.sendKeys("John Wick");

        WebElement email=driver.findElement(By.name("email"));

        Thread.sleep(2000);
        email.sendKeys("johnwick@yahoo.com"+ Keys.ENTER);


        System.out.println(driver.findElement(By.name("signup_message")).getText());
    }
}
