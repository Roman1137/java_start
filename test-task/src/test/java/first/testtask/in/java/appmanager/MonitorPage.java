package first.testtask.in.java.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MonitorPage extends HelperBase {
    public MonitorPage(ChromeDriver driver) {
        super(driver);
    }
    private String url = "https://www.centralpoint.nl/monitoren/";

    public void open() {
        driver.get(url);
        wait.until(x -> x.findElement(By.cssSelector(this.filtersTableLocator)));
    }

    public String filtersTableLocator = "#filters";

}
