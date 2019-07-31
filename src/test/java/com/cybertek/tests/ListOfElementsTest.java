package com.cybertek.tests;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class ListOfElementsTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //findElements returns List of elements

        List<WebElement> buttons=driver.findElements(By.name("sport"));
        System.out.println(buttons.size());

        //verify non selected
        for (WebElement button : buttons) {
            VerificationUtils.verifySelected(button, false);

        }

        Random random= new Random();
        int number=random.nextInt(4);

       buttons.get(number).click();

        System.out.println();
       //verify only that button is selected

       for (int i=0; i<buttons.size(); i++){
           if(i==number){
               VerificationUtils.verifySelected(buttons.get(i), true);
           }
       }


       int number2;
       do{
           number2=random.nextInt(4);
       }while(number==number2);

        System.out.println(number);
        System.out.println(number2);

        System.out.println();

       buttons.get(number2).click();
       for (int i=0; i<buttons.size(); i++) {
           if(i==number2) {
               VerificationUtils.verifySelected(buttons.get(i), true);
           }else
           {
               VerificationUtils.verifySelected(buttons.get(i), false);
           }
       }
    }
}
