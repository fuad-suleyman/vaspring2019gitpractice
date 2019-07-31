package com.cybertek.tests.page_object_model_tests;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PositiveLoginTests extends TestBase {
    @BeforeMethod
    public void setUpMethod2(){
      driver.get(ConfigurationReader.get("url"));
    }

    @Test
    public void loginDriverTest(){
        String username=ConfigurationReader.get("driver_username");
        String password=ConfigurationReader.get("driver_password");

        LoginPage loginPage = new LoginPage();

        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.submit.click();

        Assert.assertTrue(driver.getTitle().contains("Dashboard"));
    }
}
