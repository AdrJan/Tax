package core.lib.test_setup;

import core.lib.manager.driver_manager.Browsers;
import core.lib.manager.driver_manager.DriverManager;
import core.lib.manager.driver_manager.DriverManagerFactory;
import core.lib.manager.logger.TaxLogger;
import core.lib.test_base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

/**
 * Setting everything before test execution.
 *
 * @author adrianjankowski
 */

public class TestSetup extends TestBase {

    private static DriverManager driverManager;

    @Before(order = 1)
    public static void init() {
        TaxLogger.info("Starting test.");

        driverManager = DriverManagerFactory.getDriver(Browsers.CHROME);
        driver = driverManager.getWebDriver();
        TestBase.init(driver);
    }

    @Before(order = 2)
    public static void setUpEnv() {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @After
    public static void tearDown() {
        TaxLogger.info("Quitting WebDriver");
        driverManager.quitWebDriver();
    }

    protected static WebDriver driver() {
        return driver;
    }
}
