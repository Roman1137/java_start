package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionHelper {
  private ChromeDriver driver;

  public SessionHelper(ChromeDriver driver) {
    this.driver = driver;
  }
  public void login(String userName, String password) {
    this.driver.findElement(By.name("pass")).click();
    this.driver.findElement(By.name("user")).click();
    this.driver.findElement(By.name("user")).clear();
    this.driver.findElement(By.name("user")).sendKeys(userName);
    this.driver.findElement(By.id("LoginForm")).click();
    this.driver.findElement(By.name("pass")).click();
    this.driver.findElement(By.name("pass")).clear();
    this.driver.findElement(By.name("pass")).sendKeys(password);
    this.driver.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }
}
