package first.testtask.in.java.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class MonitorPage extends HelperBase {
    public MonitorPage(ChromeDriver driver) {
        super(driver);
    }

    private String url = "https://www.centralpoint.nl/monitoren/";

    public void open() {
        driver.get(url);
        wait.until(x -> x.findElement(By.cssSelector(this.filtersTableLocator)));
    }

    public WebElement selectFilterByName(String filterName) {
        return this.getFilterElements().stream()
                .filter(element -> element.getText()
                        .contains(filterName))
                .collect(Collectors.toList()).get(0);
    }


    public MonitorPage setMinimumPrice(WebElement filter, String minPrice) {
        getMinValueElement(filter).sendKeys(minPrice);
        return this;
    }

    public MonitorPage setMaximunPrice(WebElement filter, String maxPrice) {
       clearSendKeys(getMaxValueElement(filter),maxPrice);
        return this;
    }

    public void applySearch(WebElement filter){
        getSubmitButton(filter).click();
    }

    public String filtersTableLocator = "#filters";
    public String filterLocator = ".filter";
    public String minValueFieldLocator = ".minRange";
    public String maxValueFieldLocator = ".maxRange";
    public String submitSearchButton = ".filterFooter";

    public List<WebElement> getFilterElements() {
        return driver.findElements(By.cssSelector(this.filterLocator));
    }

    public WebElement getMinValueElement(WebElement element) {
        return element.findElement(By.cssSelector(this.minValueFieldLocator));
    }

    public WebElement getMaxValueElement(WebElement element) {
        return element.findElement(By.cssSelector(this.maxValueFieldLocator));
    }

    public WebElement getSubmitButton(WebElement element) {
        return element.findElement(By.cssSelector(this.submitSearchButton));
    }
}
