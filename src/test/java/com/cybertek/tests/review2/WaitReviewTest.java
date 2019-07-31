package com.cybertek.tests.review2;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class WaitReviewTest extends TestBase {

    @Test
    public void implicitWaitTest() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        WebElement message=driver.findElement(By.id("finish"));
        System.out.println(driver.getTitle());
    }

    @Test
    public void implicitWaitTest2() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        driver.findElement(By.tagName("button")).click();
        WebElement message=driver.findElement(By.id("finish"));
        System.out.println(driver.getTitle());
    }

    @Test
    public void waitForInvisibleExplicitTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));


        WebElement message=driver.findElement(By.id("finish"));
        System.out.println(message.getText());
    }
@Test
    public void waitForInvisibleExplicitTest2(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/5");

        WebElement username=driver.findElement(By.name("username"));
        WebElement password=driver.findElement(By.name("password"));
        WebElement submit=driver.findElement(By.tagName("button"));

        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));
        submit.click();
    }

    @Test
    public void testTitle() throws InterruptedException {
        driver.get("http://qa3.vytrack.com/user/login");
        VytrackUtils.login(driver, "user11", "UserUser123");
        VytrackUtils.selectMenuOption(driver, "Fleet", "Vehicles");
        wait.until(ExpectedConditions.titleContains("Car"));
        System.out.println(driver.getTitle());


    }
}