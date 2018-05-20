package first.UItesttask.in.java.appmanager.pages;

import first.UItesttask.in.java.appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class NoteBookPage extends HelperBase {

    public NoteBookPage(ChromeDriver driver) {
        super(driver);
    }
    private String url = "https://www.centralpoint.nl/notebooks-laptops/";

    public void open() {
        driver.get(url);
        wait.until(x -> x.findElement(By.cssSelector(this.filtersTableLocator)));
    }

    public WebElement selectRandomFilterWithValues() {
        WebElement filterWithValidDropDown = this.getFilterElements()
                .stream()
                .filter(element -> element.findElements(By.cssSelector(this.checkboxLocator))
                        .size()!=0).collect(Collectors.toList()).get(0);
        filterWithValidDropDown.click();

        return filterWithValidDropDown;
    }

    public String selectRandomValueInFiler(WebElement filter) {
        List<WebElement> allOptions = this.getOptionsToSelect(filter);

        WebElement optionToSelect = allOptions.get(0);
        WebElement checkboxToSelect = getCheckboxElement(optionToSelect);
        checkboxToSelect.click();
        String amountOfProducts = getAmountValueElement(optionToSelect).getText().replace("(","").replace(")","");
        applySearch(filter);

        return amountOfProducts;
    }

    private void applySearch(WebElement filter){
        getSubmitButton(filter).click();
    }

    public String filtersTableLocator = "#filters";
    public String filterLocator = ".filter";
    public String checkboxLocator = "[type='checkbox']";
    public String optionToSelectLocator = "ul li";
    public String amountValueLocator = ".number";
    public String submitSearchButton = ".filterFooter";


    public List<WebElement> getFilterElements(){
        return driver.findElements(By.cssSelector(this.filterLocator));
    }

    public List<WebElement> getOptionsToSelect(WebElement element) {
        return element.findElements(By.cssSelector(this.optionToSelectLocator));
    }

    public WebElement getCheckboxElement(WebElement element) {
        return element.findElement(By.cssSelector(this.checkboxLocator));
    }

    public WebElement getAmountValueElement(WebElement element) {
        return element.findElement(By.cssSelector(this.amountValueLocator));
    }

    public WebElement getSubmitButton(WebElement element) {
        return element.findElement(By.cssSelector(this.submitSearchButton));
    }
}
