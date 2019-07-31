package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownMenu {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement selectElement=driver.findElement(By.id("dropdown"));

        Select dropownList=new Select(selectElement);

        WebElement selectedOption=dropownList.getFirstSelectedOption();

        System.out.println(selectedOption.getText());

        List<WebElement> allOptions=dropownList.getOptions();
        System.out.println("Number of options: "+allOptions.size());

        for (WebElement allOption : allOptions) {
            System.out.println(allOption.getText());
     }
        Thread.sleep(2000);
        //HOW TO SELECT BY USING VISIBLE TEXT
        dropownList.selectByVisibleText("Option 1");

        //SELECT BY INDEX
        //index starts from 0
        Thread.sleep(2000);

        dropownList.selectByIndex(2);

        //HOW TO SELECT USING THE VALUE ATTRIBUTE
        dropownList.selectByValue("1");

        selectedOption=dropownList.getFirstSelectedOption();
        System.out.println(selectedOption.getText());
    }
}
