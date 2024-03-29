package com.cybertek.tests.properties_driver_class_test_base;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    @Test
    public void systemPropertiesTest(){

        //Syste.getProperty returns the information about the given property
        String os = System.getProperty("os.name");
        System.out.println("os = "+os);

        String user=System.getProperty("user.name");
        System.out.println("user = "+user);

        String javaVersion=System.getProperty("java.specification.version");
        System.out.println("java version = "+javaVersion);
    }

    @Test
    public void systemPropertiesTest2(){

        //
        Properties properties=System.getProperties();
        String os = properties.getProperty("os.name");
        System.out.println("os = "+os);
    }

    @Test
    public void readPropertiesFileTest() throws IOException {
        // get the filepath(location)
        String path="configuration.properties";

        // open the file
        FileInputStream fileInputStream = new FileInputStream(path);

        // load into the local object
        Properties properties=new Properties();
        properties.load(fileInputStream);

        // read properties from that object
        String url=properties.getProperty("url");
        System.out.println("url = "+url);

        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));

    }

    @Test
    public void readPropertiesTest(){
        String url= ConfigurationReader.get("url");
        System.out.println("url = "+url);

        String username=ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");

        System.out.println("username = "+username);
        System.out.println("password = "+password);
    }
}
