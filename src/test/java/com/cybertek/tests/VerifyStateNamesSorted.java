package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class VerifyStateNamesSorted {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement element=driver.findElement(By.id("state"));

        Select states=new Select(element);

        List<WebElement>options=states.getOptions();
        System.out.println("States: "+options.size());

        for(int i=0; i<options.size()-1; i++){
            String current =options.get(i).getText();
            String next =options.get(i+1).getText();
            System.out.println("Comparing "+current+" "+next);
            if(current.compareTo(next)<0){
                System.out.println("PASS");
            }else
                System.out.println("FAIL");


        }

    }
}
