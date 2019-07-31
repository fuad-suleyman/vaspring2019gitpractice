package com.cybertek.tests.extras;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DullesWifi {

    @Test
    public void wifiTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://splash.wifiplatform.com/10681bdb619cb514a1cdf95cf2d3cda6/?source=meraki&login_url=https%3A%2F%2Fn47.network-auth.com%2Fsplash%2Flogin%3Fmauth%3DMMQiLAUuA-QoKsfnT1Bd44GzXQbMCods5N9mQrpmXtJwsONNpImzwYUOKK639jEODDA2PI4k7bf4ogb1WN8apU7yBRP68kCZQBGRfmWHHFaRkhTAtgWe0PAZsWvjnJ-1gKwXynimRVbIyHetNfDWGiEJx-g39NaAA-7KLrwSIsd4hVsWHuzsHTwIoVzyZ0TbP280_9qB_21RE%26continue_url%3Dhttps%253A%252F%252Fshopdullestowncenter.com%252F&continue_url=https%3A%2F%2Fshopdullestowncenter.com%2F&ap_mac=00%3A18%3A0a%3A84%3A53%3Aee&ap_name=DTC-4261&ap_tags=West1&client_mac=f8%3A94%3Ac2%3Aea%3Af5%3Aba&client_ip=10.100.0.208#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Actions actions= new Actions(driver);
        JavascriptExecutor jse=(JavascriptExecutor)driver;

        for (int i=0; i<4; i++) {
            jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        }

        WebDriverWait wait=new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input"))));
        driver.findElement(By.xpath("//input")).click();
        driver.findElement(By.cssSelector("input[name='__first_name__']")).sendKeys("Fuad");
        driver.findElement(By.cssSelector("input[name='__last_name__']")).sendKeys("Suleyman");
        driver.findElement(By.cssSelector("input[name='__email__']")).sendKeys("fedya092@gmail.com");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
}