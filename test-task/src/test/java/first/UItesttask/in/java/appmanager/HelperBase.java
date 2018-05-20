package first.UItesttask.in.java.appmanager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class HelperBase {
    protected ChromeDriver driver;
    protected WebDriverWait wait;
    protected Random rnd;

    public HelperBase(ChromeDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.rnd = new Random();
    }

    public void clearSendKeys(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }
}
