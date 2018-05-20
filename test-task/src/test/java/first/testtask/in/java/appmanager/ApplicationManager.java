package first.testtask.in.java.appmanager;

import com.sun.glass.ui.View;
import first.testtask.in.java.appmanager.pages.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ApplicationManager {
    private ChromeDriver driver;
    private NoteBookPage noteBookPage;
    private ProductsSearchPage productSearchPagePage;
    private MonitorPage monitorPage;
    private MainPage mainPage;
    private ProductPage productPage;

    public void Init() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.noteBookPage = new NoteBookPage(this.driver);
        this.productSearchPagePage = new ProductsSearchPage(this.driver);
        this.monitorPage = new MonitorPage(this.driver);
        this.mainPage = new MainPage(this.driver);
        this.productPage = new ProductPage(this.driver);
    }

    public void Stop() {
        this.driver.close();
        this.driver.quit();
        this.driver = null;
    }

    public NoteBookPage getNoteBookHelper() {
        return this.noteBookPage;
    }

    public MonitorPage getMonitorPageHelper() {
        return this.monitorPage;
    }

    public ProductsSearchPage getProductSearchPageHelper() {
        return this.productSearchPagePage;
    }

    public MainPage getMainPageHelper() {
        return this.mainPage;
    }

    public ProductPage getProductPage() {
        return this.productPage;
    }
}
