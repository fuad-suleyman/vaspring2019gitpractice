package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTrueTest {
    @Test
    public void test(){


        String url="https://google.com";
        String expStr=".com";
        Assert.assertTrue(url.endsWith(expStr));
        Assert.assertTrue( true);

    }

    @Test
    public void test2(){

        //verify url does not end with .com
        System.out.println(1==2);

        String url="https://google.com";
        String expStr=".cm";

        //expected condition is false
        Assert.assertFalse(url.endsWith(expStr));
        Assert.assertFalse(false);

    }



}
