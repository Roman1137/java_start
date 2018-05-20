package first.testtask.in.java.tests;

import first.testtask.in.java.appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() throws Exception {
        app.Init();
    }

    @AfterMethod
    public void tearDown() {
        app.Stop();
    }
}
