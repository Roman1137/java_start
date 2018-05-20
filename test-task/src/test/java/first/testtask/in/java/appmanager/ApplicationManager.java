package first.testtask.in.java.appmanager;

import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    private ChromeDriver driver;
    private NoteBookPage noteBookPage;
    private ProductPage productPage;
    private MonitorPage monitorPage;

    public void Init() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.noteBookPage = new NoteBookPage(this.driver);
        this.productPage = new ProductPage(this.driver);
        this.monitorPage = new MonitorPage(this.driver);
    }

    public void Stop() {
        this.driver.close();
        this.driver.quit();
        this.driver = null;
    }

    public NoteBookPage getNoteBookHelper() {
        return this.noteBookPage;
    }

    public MonitorPage getMonitorPage(){
        return this.monitorPage;
    }

    public ProductPage getProductPageHelper() {
        return this.productPage;
    }
}
