package lib.actions;

import lib.manager.logger.TaxLogger;
import lib.test_setup.TestBase;
import org.testng.Assert;

/**
 * Class for keeping assertions methods, checking if specific
 */

public class TaxAssert extends TestBase {

    public void assertXpath(String xpath, String message) {
        TaxLogger.info("Assert xpath -> " + xpath);
        Assert.assertTrue(
                ell(xpath).size() > 0,
                "Assert for xpath: " + xpath + "\n" + message
        );
    }
}
