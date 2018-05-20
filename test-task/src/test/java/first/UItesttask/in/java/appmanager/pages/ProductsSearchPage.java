package first.UItesttask.in.java.appmanager.pages;

import first.UItesttask.in.java.appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductsSearchPage extends HelperBase {

    public ProductsSearchPage(ChromeDriver driver) {
        super(driver);
    }

    public String getProductAmount() {
        WebElement header = wait.until(x->x.findElement(By.cssSelector(this.headerLocator)));
        return header.getText();
    }



    public String headerLocator = "h1";

}
