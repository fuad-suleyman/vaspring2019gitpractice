package com.cybertek.tests;

import org.testng.annotations.*;
import org.testng.annotations.Test;

public class MixedAnnotations2 {
    @BeforeClass
    public void setUpClass(){
        System.out.println("setting path");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("reporting everything");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("opening browser");
    }

    @org.testng.annotations.Test
    public void test(){
        System.out.println("\ttesting the case 1");
    }


    @org.testng.annotations.Test(priority = 1)
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


