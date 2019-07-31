package com.cybertek.tests.css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssTests {
    @Test
    public void byAttributeAndValue() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String expecteddUrl = "http://practice.cybertekschool.com/multiple_buttons";
        driver.get(expecteddUrl);
        Thread.sleep(1000);

        //certain element with attribute and value combo
        System.out.println(driver.findElement(By.cssSelector("button[name='button6']")).getText());
        // any element with attribute and value combo
        System.out.println(driver.findElement(By.cssSelector("[name='button6']")).getText());
        System.out.println(driver.findElement(By.cssSelector("button[class='btn btn-primary'][name='button2']")).getText());
    }
@Test
    public void dynamicElements() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String expecteddUrl = "http://practice.cybertekschool.com/multiple_buttons";
        driver.get(expecteddUrl);
        Thread.sleep(1000);
        // starts with  ^
        System.out.println(driver.findElement(By.cssSelector("button[id^='button_']")).getText());
        // ends with    $
        System.out.println(driver.findElement(By.cssSelector("button[id$='_button']")).getText());
        // contains     *
        System.out.println(driver.findElement(By.cssSelector("button[id*='disappear']")).getText());
    }
    @Test
    public void IdAndClass() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String expecteddUrl = "http://practice.cybertekschool.com/multiple_buttons";
        driver.get(expecteddUrl);
        Thread.sleep(1000);

        //ID
        System.out.println(driver.findElement(By.cssSelector("#disappearing_button")).getText());
    }
}
