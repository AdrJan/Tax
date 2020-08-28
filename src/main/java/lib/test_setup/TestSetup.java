package lib.test_setup;

import lib.actions.TaxAction;
import lib.actions.TaxAsserts;
import lib.manager.driver_manager.Browsers;
import lib.manager.driver_manager.DriverManager;
import lib.manager.driver_manager.DriverManagerFactory;
import lib.manager.logger.TaxLogger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

/**
 * Setting method for initializing webdriver before test
 *
 * @author Adrian Jankowski
 */

public class TestSetup extends TestBase {

    protected static DriverManager driverManager;

    @BeforeSuite
    public void setUpSuite() {
        TaxLogger.info("Setting up test suite");
        driverManager = DriverManagerFactory.getDriver(Browsers.CHROME);
        driver = driverManager.getWebDriver();

        taxAction = new TaxAction();
        taxAsserts = new TaxAsserts();

        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void setUpTest() {
        driver.manage().deleteAllCookies();
        TaxLogger.testStarts();
    }

    @AfterMethod
    public void testClose() {
        TaxLogger.testEnds();
    }

    @AfterSuite
    public void tearDown() {
        TaxLogger.info("Quitting WebDriver");
        driverManager.quitWebDriver();
    }

    protected static WebDriver driver() {
        return driver;
    }
}
