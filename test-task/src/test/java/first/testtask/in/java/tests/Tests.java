package first.testtask.in.java.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Tests extends TestBase {

    @Test
    public void VerifyAmountOfProducts() {
        app.getNoteBookHelper().open();
        WebElement filterElement = app.getNoteBookHelper().selectRandomFilterWithValues();
        String productsAmount = app.getNoteBookHelper().selectRandomValueInFiler(filterElement);
        String productAmountDisplayed = app.getProductPageHelper().getProductAmount();
        Assert.assertTrue(productAmountDisplayed.contains(productsAmount));
    }

    @Test
    @Parameters({"Prijs", "1000", "5000"})
    public void VerifyPriceConstraints(String filterName, String minPrice, String maxPrice) {
        app.getMonitorPage().open();
        WebElement filter = app.getMonitorPage().selectFilterByName(filterName);
        app.getMonitorPage()
                .setMinimumPrice(filter, minPrice)
                .setMaximunPrice(filter, maxPrice)
                .applySearch(filter);

    }


}
