package com.cybertek.tests;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextVerification {

    public static void main(String[] args) throws InterruptedException {
      //  test003();
        test004();
    }

    public static void test003() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        Thread.sleep(1000);
        WebElement emailInput=driver.findElement(By.name("email"));

        // sendKeys()==>enter text on webelement
        emailInput.sendKeys("fuad@gmail.com");

        Thread.sleep(1000);
        WebElement retrieveClick=driver.findElement(By.id("form_submit"));
        retrieveClick.click();

        WebElement message= driver.findElement(By.name("confirmation_message"));
        System.out.println(message.getText());

        String exp="Your e-mail's been sent!";
        String act=message.getText();
        VerificationUtils.verifyEquals(exp,act);

        driver.close();

    }

    public static void test004() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        Thread.sleep(1000);
        WebElement emailInput=driver.findElement(By.name("email"));
        String exp="fuad@gmail.com";
        // sendKeys()==>enter text on webelement
        emailInput.sendKeys("fuad@gmail.com");

        String act=emailInput.getAttribute("name");

        Thread.sleep(1000);
        WebElement retrieveClick=driver.findElement(By.id("form_submit"));
        retrieveClick.click();
        driver.close();

        VerificationUtils.verifyEquals(exp,act);
        System.out.println(act);
    }
}
