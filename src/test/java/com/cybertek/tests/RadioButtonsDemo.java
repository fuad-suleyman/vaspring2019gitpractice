package com.cybertek.tests;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonsDemo {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //verify blue selected
        //verify red is not selected

        WebElement red= driver.findElement(By.id("red"));
        WebElement blue= driver.findElement(By.id("blue"));

      //  blue.isSelected();
        System.out.println("Blue: "+blue.isSelected());
        System.out.println("Red "+red.isSelected());

        System.out.println("Selecting red");

        red.click();

//      verify blue is not selected
        VerificationUtils.verifySelected(blue, false);
        VerificationUtils.verifySelected(red,true);

        WebElement yellow = driver.findElement(By.id("yellow"));

        System.out.println("Yellow is enabled "+yellow.isEnabled());
        System.out.println("Red is enabled "+red.isEnabled());

        yellow.click();
        VerificationUtils.verifySelected(yellow, false);

        System.out.println("Yellow is enabled "+yellow.isEnabled());

    }
}
