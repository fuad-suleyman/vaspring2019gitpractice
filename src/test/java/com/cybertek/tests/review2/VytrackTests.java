package com.cybertek.tests.review2;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.VerificationUtils;
import com.cybertek.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VytrackTests extends TestBase {

    @Test
    public void changeMenu(){
        driver.get(ConfigurationReader.get("url"));
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        VytrackUtils.login(driver, username, password);

        Assert.assertTrue(driver.getTitle().contains("Dashboard"),
                "Title message was wrong");

        VytrackUtils.selectMenuOption(driver, "Activities", "Calls");
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Calls"),
                "Title message was wrong");

    }

    @Test
    public void verifyRepeatOptions(){
        driver.get(ConfigurationReader.get("url"));

        String username=ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");

        VytrackUtils.login(driver, username, password);
        VytrackUtils.selectMenuOption(driver, "Activities", "Calendar Events");

        VytrackUtils.waitForUIOverlay();
        BrowserUtils.waitForClickablility(driver.findElement(By.cssSelector("a[title='Create Calendar event']")),5).click();
        //input[id^=recurrence-repeat-view]
        VytrackUtils.waitForUIOverlay();
        driver.findElement(By.cssSelector("input[id^=recurrence-repeat-view]")).click();

        WebElement el = driver.findElement(By.cssSelector("select[id^='recurrence-repeats-view']"));
        Select repaeatOptionsDropdownList=new Select(el);

        List<String>expected = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");

        List<WebElement>options=repaeatOptionsDropdownList.getOptions();

        List<String>actual=BrowserUtils.getElementsText(options);

        for (String s : actual) {
            System.out.println(s);
        }

        Assert.assertEquals(actual, expected, "Repeat options did not match");

    }
}