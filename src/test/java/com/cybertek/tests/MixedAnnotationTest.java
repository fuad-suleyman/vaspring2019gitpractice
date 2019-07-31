package com.cybertek.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MixedAnnotationTest {


    @BeforeMethod
    public void setUp(){
        System.out.println("opening browser");
    }

    @Test
    public void test(){
      System.out.println("\ttesting the case 1");
    }


    @Test(priority = 1)
    public void test2 (){
   System.out.println("\ttesting the case 2");
    }

    @Test(priority = 2)
    public void test3 (){
        System.out.println("\ttesting the case 3");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("closing browser"+"\n");
    }

}
