package first.UItesttask.in.java.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tests extends TestBase {

    @Test
    public void verifyAmountOfProducts() {
        app.getNoteBookHelper().open();
        WebElement filterElement = app.getNoteBookHelper().selectRandomFilterWithValues();
        String productsAmount = app.getNoteBookHelper().selectRandomValueInFiler(filterElement);
        String productAmountDisplayed = app.getProductSearchPageHelper().getProductAmount();
        Assert.assertTrue(productAmountDisplayed.contains(productsAmount));
    }

    @Test(dataProvider = "getPricesForFilter")
    public void verifyPriceConstraints(String filterName, String minPrice, String maxPrice) {
        app.getMonitorPageHelper().open();
        WebElement filter = app.getMonitorPageHelper().selectFilterByName(filterName);
        app.getMonitorPageHelper()
                .setMinimumPrice(filter, minPrice)
                .setMaximunPrice(filter, maxPrice)
                .applySearch(filter);
        String price = app.getMonitorPageHelper().getPriceOfCheapestItem();
        Assert.assertTrue(Integer.parseInt(price) >= Integer.parseInt(minPrice));
    }

    @Test(dataProvider = "getProdIdList")
    public void verifyProductByProdId(String prodId) {
        app.getMainPageHelper()
                .open()
                .fillTheSearchFieldWithValue(prodId)
                .initSearch();
        Boolean isPageOpened = app.getProductPage().isPageOpened(prodId);
        Assert.assertTrue(isPageOpened, String.format
                ("The page with prodId %s should have opened but it didn't. ", prodId));
    }

    @DataProvider
    public Object[] getProdIdList() {
        String values =
                "J153289\n" +
                        "MQ3D2ZD/A\n" +
                        "L36852-H2436-M101\n" +
                        "1WZ03EA#ABH\n" +
                        "875839-425\n" +
                        "C5J91A#B19\n" +
                        "FM32SD45B/10\n" +
                        "204446-101\n" +
                        "GV-N710D3-1GL\n" +
                        "02G-P4-6150-KR";

        Object[] list = values.split("\n");
        return list;
    }

    @DataProvider
    public Iterator<Object[]> getPricesForFilter() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Prijs", "1000", "5000"});
        return list.iterator();
    }
}
