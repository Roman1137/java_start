package first.testtask.in.java.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductPage extends HelperBase{

    public ProductPage(ChromeDriver driver) {
        super(driver);
    }

    public String getProductAmount() {
        WebElement header = wait.until(x->x.findElement(By.cssSelector(this.headerLocator)));
        return header.getText();
    }

    public String headerLocator = "h1";
}
