package first.testtask.in.java.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tests extends TestBase {

    @Test
    public void VerifyAmountOfProducts() {
        app.getNoteBookHelper().open();
        WebElement filterElement = app.getNoteBookHelper().selectRandomFilterWithValues();
        String productsAmount = app.getNoteBookHelper().selectRandomValueInFiler(filterElement);
        String productAmountDisplayed = app.getProductPageHelper().getProductAmount();
        Assert.assertTrue(productAmountDisplayed.contains(productsAmount));
    }

    @Test(dataProvider = "pricesForFilter")
    public void VerifyPriceConstraints(String filterName, String minPrice, String maxPrice) {
        app.getMonitorPage().open();
        WebElement filter = app.getMonitorPage().selectFilterByName(filterName);
        app.getMonitorPage()
                .setMinimumPrice(filter, minPrice)
                .setMaximunPrice(filter, maxPrice)
                .applySearch(filter);
        String price = app.getMonitorPage().getPriceOfCheapestItem();
        Assert.assertTrue(Integer.parseInt(price) >= Integer.parseInt(minPrice));
    }

    @DataProvider
    public Iterator<Object[]> pricesForFilter() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Prijs", "1000", "5000"});

        return list.iterator();
    }
}
