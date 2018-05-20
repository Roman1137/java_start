package first.testtask.in.java.tests;

import first.testtask.in.java.appmanager.ApplicationManager;
import org.testng.annotations.*;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp() throws Exception {
        app.Init();
    }

    @AfterClass
    public void tearDown() {
        app.Stop();
    }
}
