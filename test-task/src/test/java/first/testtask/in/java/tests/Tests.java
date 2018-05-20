package first.testtask.in.java.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
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

}
