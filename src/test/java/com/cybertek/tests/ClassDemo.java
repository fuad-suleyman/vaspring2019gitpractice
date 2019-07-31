package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassDemo {
    public static void class1(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/sign_up");

        System.out.println( driver.findElement(By.className("subheader")).getText());
        driver.findElement(By.className("nav-link")).click();


    }

    public static void class2(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //driver.findElement(By.className("btn btn-primary")).click(); if class name is more than one word it is not gonna work
        System.out.println(driver.findElement(By.className("btn btn-primary")).getText());
    }

    public static void main(String[] args) {
        class2();
    }
}
