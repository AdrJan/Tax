package core.lib.actions;

import core.lib.manager.logger.TaxLogger;
import core.lib.testbase.SeleniumWrapper;
import org.testng.Assert;

/**
 * Class for keeping assertions methods, checking if specific
 */

public class TaxAssert {

    SeleniumWrapper sw;

    public TaxAssert(SeleniumWrapper sw) {
        this.sw = sw;
    }

    public void assertXpath(String xpath, String message) {
        TaxLogger.info("Assert xpath -> " + xpath);
        Assert.assertFalse(sw.ell(xpath).isEmpty(), "Assert for xpath: " + xpath + "\n" + message);
    }
}
