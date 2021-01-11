package core.lib.test_setup;

import core.lib.actions.TaxAction;
import core.lib.actions.TaxAssert;
import core.lib.actions.TaxWait;
import org.openqa.selenium.WebDriver;

/**
 * Wrapped webdriver basic methods for easier usage.
 *
 * @author adrianjankowski
 */

public abstract class TestBase {

    protected static SeleniumWrapper sw;

    protected static WebDriver driver;

    protected TestBase() {

    }

    protected static TaxAction taxAction;
    protected static TaxAssert taxAssert;
    protected static TaxWait taxWait;

    protected static void init(WebDriver driver) {
        sw = new SeleniumWrapper(driver);
        taxAction = new TaxAction(driver);
        taxWait = new TaxWait(driver);
        taxAssert = new TaxAssert();
    }
}
