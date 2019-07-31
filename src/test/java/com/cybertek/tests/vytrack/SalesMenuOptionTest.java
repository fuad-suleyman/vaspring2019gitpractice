package com.cybertek.tests.vytrack;

import com.cybertek.utilities.VerificationUtils;
import com.cybertek.utilities.VytrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SalesMenuOptionTest {
WebDriver driver;

@BeforeMethod
public void setUpTest(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.get("http://qa3.vytrack.com");
}

@AfterMethod
public void tearDown(){
    driver.quit();
}

    @Test
    public  void managerTest() throws InterruptedException {


        VytrackUtils.login(driver, "storemanager52", "UserUser123");

        Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='title title-level-1'])[4]")).isDisplayed());

    }
    @Test
    public  void driverTest() throws InterruptedException {
        VytrackUtils.login(driver, "user15", "UserUser123");

        String xpath="//span[@class='title title-level-1' and contains(text(),'Sales')]";

        Assert.assertFalse(VerificationUtils.isElementDisplayed(driver, By.xpath(xpath)));



    }
}
