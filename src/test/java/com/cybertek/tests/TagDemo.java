package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagDemo {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement element= driver.findElement(By.tagName("h2"));
        System.out.println(element.getText());


        driver.findElement(By.tagName("input")).sendKeys("John Wick");
        driver.findElement(By.name("email")).sendKeys("JohnWick@gmail.com");
        driver.findElement(By.tagName("button")).click();
        //click home
        driver.findElement(By.tagName("a")).click();


    }
}
