package com.cybertek.tests;

import com.cybertek.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUpMethod(){
        driver= Driver.get();

        //setting implicitly wait -> when element not found will keep try to find it in 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      //Actions class enable intreacts actions like hover over drg and drop
        actions=new Actions(driver);

        //set up the explicit wait object
       // wait=new WebDriverWait(driver, 10);
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
Thread.sleep(3000);
        Driver.closeDriver();
    }

}
