package lib.test_setup;

import lib.actions.TaxAction;
import lib.manager.driver_manager.Browsers;
import lib.manager.driver_manager.DriverManager;
import lib.manager.driver_manager.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
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
    public void setUp() {
        System.out.println("Setting up WebDriver");
        driverManager = DriverManagerFactory.getDriver(Browsers.CHROME);
        driver = driverManager.getWebDriver();
        taxAction = new TaxAction();

        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void clearCookie() {
        driver.manage().deleteAllCookies();
    }

    @AfterTest
    public void tearDown() {
        close();
    }

    public void close() {
        System.out.println("Quitting WebDriver");
        driverManager.quitWebDriver();
    }

    protected static WebDriver driver() {
        return driver;
    }
}
