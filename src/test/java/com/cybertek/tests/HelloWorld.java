package com.cybertek.tests;

import com.github.javafaker.Faker;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello world");

        Faker faker=new Faker();

        System.out.println( faker.name().fullName());
        System.out.println(faker.color().name());
        System.out.println(faker.chuckNorris().fact());

    }
}
