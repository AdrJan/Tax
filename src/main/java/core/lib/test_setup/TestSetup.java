package core.lib.test_setup;

import core.lib.manager.driver_manager.Browsers;
import core.lib.manager.driver_manager.DriverManager;
import core.lib.manager.driver_manager.DriverManagerFactory;
import core.lib.manager.logger.TaxLogger;
import core.lib.test_base.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

/**
 * Setting everything before test execution.
 *
 * @author adrianjankowski
 */

public class TestSetup extends TestBase {

    private static DriverManager driverManager;

    @BeforeSuite
    public static void setUpSuite() {
        TaxLogger.info("Setting up test suite");

        driverManager = DriverManagerFactory.getDriver(Browsers.CHROME);
        driver = driverManager.getWebDriver();

        init(driver);

        driver.manage().window().maximize();
    }

    @BeforeMethod
    public static void setUpTest() {
        driver.manage().deleteAllCookies();
        TaxLogger.testStarts();
    }

    @AfterMethod
    public static void testClose() {
        TaxLogger.testEnds();
    }

    @AfterSuite
    public static void tearDown() {
        TaxLogger.info("Quitting WebDriver");
        driverManager.quitWebDriver();
    }

    protected static WebDriver driver() {
        return driver;
    }
}
