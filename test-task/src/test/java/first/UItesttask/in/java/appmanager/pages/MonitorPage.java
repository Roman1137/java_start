package first.UItesttask.in.java.appmanager.pages;

import first.UItesttask.in.java.appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        WebElement filter = this.getFilterElements().stream()
                .filter(element -> element.getText()
                        .contains(filterName))
                .collect(Collectors.toList()).get(0);
        filter.click();
        return filter;
    }

    public void setAscSorting() {
        WebElement sortFilter = this.selectFilterByName("Sortering");
        WebElement optionToSelect = sortFilter.findElements(By.cssSelector(this.optionToSelectLocator))
                .stream().filter(element -> element.getText().contains("Prijs, oplopend"))
                .collect(Collectors.toList()).get(0);
        WebElement elementToBecomeStale = this.getFirstProductPriceElement();
        optionToSelect.click();
        wait.until(ExpectedConditions.stalenessOf(elementToBecomeStale));
    }


    public MonitorPage setMinimumPrice(WebElement filter, String minPrice) {
        clearSendKeys(getMinValueElement(filter),minPrice);
        return this;
    }

    public MonitorPage setMaximunPrice(WebElement filter, String maxPrice) {
        clearSendKeys(getMaxValueElement(filter), maxPrice);
        return this;
    }

    public void applySearch(WebElement filter) {
        getSubmitButton(filter).click();
    }

    public String getPriceOfCheapestItem() {
        this.setAscSorting();
        String allText = wait.until(x -> x.findElements(By.cssSelector(this.productPriceLocator))
                .get(0).getText());
        String price = null;
        String pattern = "\\d+";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(allText);
        while (m.find()) {
            price = m.group();
        }
        return price;
    }

    public String filtersTableLocator = "#filters";
    public String filterLocator = ".filter";
    public String minValueFieldLocator = ".minRange";
    public String maxValueFieldLocator = ".maxRange";
    public String submitSearchButton = ".filterFooter";
    public String optionToSelectLocator = "ul li a";
    public String productPriceLocator = ".price.priceExcl";

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

    public WebElement getFirstProductPriceElement() {
        return driver.findElements(By.cssSelector(this.productPriceLocator)).get(0);
    }


}
