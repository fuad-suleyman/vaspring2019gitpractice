package com.cybertek.tests.extras;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class VytrackPractice extends TestBase {

    @Test
    public void test(){
        driver.get(ConfigurationReader.get("url"));

        LoginPage loginpage=new LoginPage();
        loginpage.login("storemanager51", "UserUser123");

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.selectMenuOption("Activities", "Calendar Events");
        BrowserUtils.waitFor(1);
        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.createCalendarEvent.click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String date = (String) jse.executeScript("return arguments[0].value", driver.findElement(By.cssSelector("[id^='date_selector_oro_calendar_event_form_end']")));

        System.out.println("Date: "+date);
    }


}
