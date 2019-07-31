package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertEqualsTest {

    @Test
    public void test(){
        String exp="Google";
        String actual="Google";

        Assert.assertEquals(exp,actual);
    }
    @Test
    public void test2(){
        String exp="Googl";
        String actual="Google";

        Assert.assertEquals(exp,actual);
    }
}
