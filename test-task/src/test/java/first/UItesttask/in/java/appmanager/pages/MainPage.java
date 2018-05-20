package first.UItesttask.in.java.appmanager.pages;

import first.UItesttask.in.java.appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class MainPage extends HelperBase {
    public MainPage(ChromeDriver driver) {
        super(driver);
    }

    private String url = "https://www.centralpoint.nl/monitoren/";

    public MainPage open() {
        driver.get(url);
        wait.until(x -> x.findElement(By.cssSelector(this.searchFieldInputLocator)));
        return this;
    }

    public MainPage fillTheSearchFieldWithValue(String text) {
        clearSendKeys(this.getSearchFieldInputElement(), text);
        return this;
    }

    public MainPage initSearch() {
        this.getSearchSubmitButtonElement().click();
        return this;
    }

    public String searchFieldInputLocator = ".sticky .container input[name=search]";
    public String searchSubmitButtonLocator = ".sticky .container [type=submit]";

    public WebElement getSearchFieldInputElement() {
        return driver.findElement(By.cssSelector(this.searchFieldInputLocator));
    }

    public WebElement getSearchSubmitButtonElement() {
        return driver.findElement(By.cssSelector(this.searchSubmitButtonLocator));
    }
}
