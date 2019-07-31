package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCalendarEventsPage extends NavigationBar{

    public CreateCalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public WebElement getTab(String tab) {
        String tabXpath = "//span[@class='title title-level-1' and contains(text(), '" + tab + "')]";
        return Driver.get().findElement(By.xpath(tabXpath));
    }

    public WebElement getModule(String module) {
        String moduleXpath = "//span[@class='title title-level-2' and contains(text(), '" + module + "')]";
        return Driver.get().findElement(By.xpath(moduleXpath));
    }


    public void selectMenuOption(String tab, String module) {
        WebElement tabEl = getTab(tab);
        BrowserUtils.hover(tabEl);

        WebElement moduleEl = getModule(module);
        BrowserUtils.waitForClickablility(moduleEl, 5).click();

        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        wait.until(ExpectedConditions.titleContains(module));
    }


    @FindBy(css = "[id^='recurrence-repeat-view']")
    public WebElement repeat;

    @FindBy(css = "[id^='recurrence-repeats-view']")
    public WebElement repeatOptions;


    public Select repeatOptionsList(){
        return new Select(repeatOptions);
    }

}