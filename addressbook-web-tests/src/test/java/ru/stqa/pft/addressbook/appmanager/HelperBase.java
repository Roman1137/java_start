package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelperBase {
    protected ChromeDriver driver;

    public HelperBase(ChromeDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {
        this.driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        this.driver.findElement(locator).clear();
        this.driver.findElement(locator).sendKeys(text);
    }
}
