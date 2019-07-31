package com.cybertek.tests.webtables;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTableDemoTest extends TestBase {
    @BeforeMethod
    public void setUpMethodGetThatSite() {
        driver.get(ConfigurationReader.get("url"));
    }

    @Test
    public void printTable() {


        WebElement table = driver.findElement(By.id("table1"));

        System.out.println(table.getText());


    }

    @Test
    public void headersTest() {


        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        for (WebElement header : headers) {
            System.out.println(header.getText());
        }

        System.out.println("heasers.sizer() = " + headers.size());
    }

    @Test
    public void tableSizeTest() {
        //TODO number of columns
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Number of columns: " + headers.size());

        //TODO number of rows including headers
        List<WebElement> rowsWithHeaders = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("Number of rows including headers: " + rowsWithHeaders.size());


        //TODO number of rows without header
        List<WebElement> rowsWithOutHeaders = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("Number of rows without header: " + rowsWithOutHeaders.size());
    }

    //get whole row
    @Test
    public void getWholeRow() {
        WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]"));
        System.out.println(row.getText());

        int index = 4;
        String rowPath = "//table[@id='table1']/tbody/tr[" + index + "]";
        row = driver.findElement(By.xpath(rowPath));

        System.out.println(row.getText());

    }

    @Test
    public void getCellsinRow() {
        List<WebElement> cellsInRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));

        cellsInRow.forEach(cell -> System.out.println(cell.getText()));

        System.out.println("cellsInRow.size() = " + cellsInRow.size());
        int index = 3;
        String cellsInRowXpath = "//table[@id='table1']/tbody/tr[" + index + "]/td";

        cellsInRow = driver.findElements(By.xpath(cellsInRowXpath));
        cellsInRow.forEach(cell -> System.out.println(cell.getText()));
    }

    //get certain cell
    @Test
    public void getCellTest(){
        WebElement cell=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[1]"));
        System.out.println(cell.getText() );
    }

    @Test
    public void getCellMethod(){
        WebElement cell=getCell(3, 4);
        Assert.assertEquals(cell.getText(), "$100.00");

        cell=getCell(4 , 5);
        Assert.assertEquals(cell.getText(), "http://www.timconway.com");
    }
    // how do you get a value from cell based on its coordinates/index
    public WebElement getCell(int rowIndex, int colIndex){
       String xpath="//table[@id='table1']/tbody/tr["+rowIndex+"]/td["+colIndex+"]";

        return driver.findElement(By.xpath(xpath));
    }

    //go to the page
    //click on eamail
    //verify email column is sorted in ascendeing order

    @Test
    public void columnSortTest(){
        //click on column email
        //get all column names
        //click on column email

        List<WebElement>colNames=getAllColumnNames();

        System.out.println(colNames);
        for (WebElement colName : colNames) {
            if (colName.getText().equals("Email")){
                colName.click();
            }
        }
        int colIndex=getColumnIndex("Email");
        System.out.println(colIndex);

        //generate the xpath all cells under the email col
        String xpath="//tabel[@id='table1']/tbody/tr/td["+colIndex+"]";

        List<WebElement>allEmails=driver.findElements(By.xpath(xpath));
        for (WebElement allEmail : allEmails) {
            System.out.println(allEmail.getText());
        }
        }

    private List<WebElement> getAllColumnNames() {
        List<WebElement>cols=driver.findElements(By.xpath("//table[@id='table1']//th"));
        List<String> colNames= BrowserUtils.getElementsText(cols);

        return cols;
    }
    private  int getColumnIndex (String col){
        List<WebElement>cols=getAllColumnNames();
        for (int i=0; i<cols.size(); i++){
            if (cols.get(i).getText().equals(col)){
                return i+1;
            }
        }
        return 0;
    }
}
