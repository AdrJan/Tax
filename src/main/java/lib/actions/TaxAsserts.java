package lib.actions;

import lib.manager.logger.TaxLogger;
import lib.test_setup.TestBase;
import org.testng.Assert;

/**
 * Class for keeping assertions methods, checking if specific
 */

public class TaxAsserts extends TestBase {

    private static final double DELTA = 0.001;

    public void assertXpath(String xpath, String message) {
        TaxLogger.info("Assert xpath -> " + xpath);
        Assert.assertTrue(
                ell(xpath).size() > 0,
                "Assert for xpath: " + xpath + "\n" + message
        );
    }

    public void assertTwoDoublesEqual(double double1, double double2) {
        TaxLogger.info("Assert two doubles equals -> " + double1 + ", " + double2);
        Assert.assertEquals(
                double1, double2, DELTA
        );
    }
}
