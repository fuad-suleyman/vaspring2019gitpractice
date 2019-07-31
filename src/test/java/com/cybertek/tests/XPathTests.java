package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XPathTests {

    @Test
    public void Test () {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/signup_confirmation");

        String expecteddUrl = "http://practice.cybertekschool.com/signup_confirmation";

        System.out.println("Printing the first link");

        System.out.println(driver.findElement(By.xpath("/html/body/nav/ul/li/a")).getText());

        System.out.println("Printing the second link");

        System.out.println(driver.findElement(By.xpath("html/body/div/div/div/div/a/i")).getText());
    }
        @Test

          public void relativeXPathUsingParentChild (){

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            String expecteddUrl = "http://practice.cybertekschool.com/signup_confirmation";
            driver.get(expecteddUrl);

            System.out.println(driver.findElement(By.xpath("//a")).getText());

    }

    @Test
    public void dsa() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String expecteddUrl = "http://practice.cybertekschool.com/multiple_buttons";
        driver.get(expecteddUrl);

        System.out.println("Click on the button: Don't click ");
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//button[@id='disappearing_button']")).click();

        //Contains Certain String in Value of Some Attribute

        System.out.println(driver.findElement(By.xpath("//button[contains(@id,'button_')]")).getText());
    }

    @Test
    public void relativeXPathUsingText(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String expecteddUrl = "http://practice.cybertekschool.com/multiple_buttons";
        driver.get(expecteddUrl);

        //Using exact text

        //System.out.println(driver.findElement(By.xpath("//button[.='Button 4']")).getText());

        //Using Partial text
        //tagName[contains(text(),'value')]
        System.out.println(driver.findElement(By.xpath("//button[contains(text(),'click')]")).getText());
    }

    @Test
    public void relativeXPathByindex(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String expecteddUrl = "http://practice.cybertekschool.com/multiple_buttons";
        driver.get(expecteddUrl);

        //Nth Child
        System.out.println(driver.findElement(By.xpath("//button[1]")).getText());

    }
}
