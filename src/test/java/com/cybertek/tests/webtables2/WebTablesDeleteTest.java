package com.cybertek.tests.webtables2;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesDeleteTest extends TestBase {

    @Test
    public void test(){
        driver.get(ConfigurationReader.get("url"));
        WebElement delete=driver.findElement(By.xpath("//table[@id='table1']//td[.='http://www.timconway.com']/../td[6]/a[2]"));
        delete.click();

        TableOneTest tableOneTest=new TableOneTest();

        List<WebElement>emails=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
        List<String>emailsStr= BrowserUtils.getElementsText(emails);

        Assert.assertFalse(emailsStr.contains("tconway@gmail.com"));
    }
}
