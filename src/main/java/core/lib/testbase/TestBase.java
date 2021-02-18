package core.lib.testbase;

import core.lib.actions.TaxAction;
import core.lib.actions.TaxAssert;
import core.lib.actions.TaxWait;
import core.lib.manager.logger.TaxLogger;
import org.openqa.selenium.WebDriver;

/**
 * Wrapped webdriver basic methods for easier usage.
 *
 * @author adrianjankowski
 */

public abstract class TestBase {

    protected static SeleniumWrapper sw;
    protected static WebDriver driver;

    protected static TaxAction taxAction;
    protected static TaxAssert taxAssert;
    protected static TaxWait taxWait;

    protected static void init(WebDriver driver) {
        TaxLogger.info("Initializing TestBase.");
        sw = new SeleniumWrapper(driver);
        taxWait = new TaxWait(driver);
        taxAction = new TaxAction(driver, taxWait);
        taxAssert = new TaxAssert(sw);
    }
}
