package first.UItesttask.in.java.appmanager.pages;

import first.UItesttask.in.java.appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductPage extends HelperBase {
    public ProductPage(ChromeDriver driver) {
        super(driver);
    }

    public String productDetailsLocator = ".productDetail";

    public boolean isPageOpened(String prodId) {
        return wait.until(dr ->
                dr.findElement(By.cssSelector(this.productDetailsLocator)).isDisplayed()
                        && wait.until(x->x.getTitle().contains(prodId)));
    }
}
