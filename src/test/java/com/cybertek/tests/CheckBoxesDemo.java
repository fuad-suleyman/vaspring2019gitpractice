package com.cybertek.tests;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxesDemo {

    /*
     They are like radio buttons in some ways. They also have states: selected or not selected.
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");

        //verify default
        //xpath  for the finf child by tag and index. n'th child
        WebElement one= driver.findElement(By.xpath("//input[1]"));
        WebElement two= driver.findElement(By.xpath("//input[2]"));

        System.out.println("one "+one.isSelected());
        System.out.println("two "+two.isSelected());

        System.out.println("Verifying default");

        VerificationUtils.verifySelected(one, false);
        VerificationUtils.verifySelected(two, true);

        System.out.println("Clicking on one");
        one.click();

        VerificationUtils.verifySelected(one, true);
        VerificationUtils.verifySelected(two, true);

        System.out.println("Clicking on two");

        two.click();

        VerificationUtils.verifySelected(one, true);
        VerificationUtils.verifySelected(two, false);


        System.out.println(one.getAttribute("type"));

        System.out.println(one.getAttribute("checked"));
        System.out.println(two.getAttribute("checked"));
    }

}
