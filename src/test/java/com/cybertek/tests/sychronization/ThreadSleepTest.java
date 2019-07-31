package com.cybertek.tests.sychronization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSleepTest {
    WebDriver driver;



    @BeforeMethod
    public void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        Thread.sleep(2000);

    }
    @Test

    public void threadSleepTest() throws InterruptedException {
        driver.findElement(By.tagName("button")).click();

        Thread.sleep(5000);
        WebElement message=   driver.findElement(By.id("finish"));

        System.out.println(message.getText());
    }
}
