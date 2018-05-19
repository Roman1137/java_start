package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private SessionHelper sessionHelper;
    ChromeDriver driver;

    public void Init() {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        this.driver.get("http://localhost/addressbook/index.php");
        this.groupHelper = new GroupHelper(this.driver);
        this.navigationHelper = new NavigationHelper(this.driver);
        this.sessionHelper = new SessionHelper(this.driver);
        this.sessionHelper.login("admin", "secret");
    }

    public void Stop() {
        this.driver.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
