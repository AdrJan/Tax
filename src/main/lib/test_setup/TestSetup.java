package test_setup;

import actions.TaxAction;
import manager.driver_manager.Browsers;
import manager.driver_manager.DriverManager;
import manager.driver_manager.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

/**
 * Setting method for initializing webdriver before test
 *
 * @author Adrian Jankowski
 */

public class TestSetup extends TestBase {

    protected static DriverManager driverManager;

    @BeforeClass
    public void setUp() {
        System.out.println("Setting up WebDriver");
        driverManager = DriverManagerFactory.getDriver(Browsers.CHROME);
        driver = driverManager.getWebDriver();
        taxAction = new TaxAction();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
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
