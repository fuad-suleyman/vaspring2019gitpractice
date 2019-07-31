package com.cybertek.tests.jse_and_actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void hover() throws InterruptedException {

        Actions actions = new Actions(driver);
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement element = driver.findElement(By.tagName("img"));


        Thread.sleep(2000);
        actions.moveToElement(element).perform();


        //JavascriptExecutor jse= (JavascriptExecutor) driver;

    }

    @Test
    public void hover2() throws InterruptedException {

        Actions actions = new Actions(driver);
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        Thread.sleep(1000);

        WebElement firstOne = driver.findElement(By.id("ui-id-3"));
        WebElement secondOne = driver.findElement(By.id("ui-id-4"));

        actions.moveToElement(firstOne).perform();

        Thread.sleep(1500);

        actions.moveToElement(firstOne).perform();
    }

    @Test
    public void chainingActions() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        Thread.sleep(1000);

        WebElement firstOne = driver.findElement(By.id("ui-id-3"));
        WebElement secondOne = driver.findElement(By.id("ui-id-4"));
        actions.moveToElement(firstOne).pause(1000).moveToElement(secondOne).build().perform();

    }

    @Test
    public void dragDrop() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Thread.sleep(1000);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));


        actions.dragAndDrop(source, target).perform();
    }

    @Test
    public void dragDropChain() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Thread.sleep(1000);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        actions.clickAndHold(source).pause(1000).moveToElement(target).build().perform();
    }
}