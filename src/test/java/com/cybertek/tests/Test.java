package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void test001(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("iphone x"+ Keys.ENTER);
        System.out.println(driver.findElement(By.className("srp-controls__count-heading")).getText());
    }

    public static void test002(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("ps4");
        driver.findElement(By.className("nav-input")).click();
        System.out.println(driver.getTitle().contains("ps4"));
    }

    public static void test003(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://wikipedia.org");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver");
        driver.findElement(By.tagName("button")).click();
        System.out.println(driver.getCurrentUrl().endsWith("Selenium_(software)"));

    }

    public static void main(String[] args) {
        test002();
    }



}
