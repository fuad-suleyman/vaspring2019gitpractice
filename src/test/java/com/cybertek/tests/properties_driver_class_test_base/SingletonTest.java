package com.cybertek.tests.properties_driver_class_test_base;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {
    @Test
    public void test(){

        String str1=Singleton.getInstance();
        String str2=Singleton.getInstance();

        System.out.println("str1 = "+str1);
        System.out.println("str2 = "+str2);

    }
    @Test
    public void test1(){
        WebDriver driver=Driver.get();

        driver.get(ConfigurationReader.get("url"));

    }

    @Test
    public void test2(){
        Driver.get().get(ConfigurationReader.get("url"));
    }
}
