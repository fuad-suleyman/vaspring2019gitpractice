package com.cybertek.tests.properties_driver_class_test_base;

public class Singleton {

    private static String string;

    public static String getInstance(){

        if (string==null){
            System.out.println("GIVING VALUE NOW");
            string="i have a value now";
        }else
        {
            System.out.println("ALREADY HAS VALUE");
        }
        return string;
    }

}
