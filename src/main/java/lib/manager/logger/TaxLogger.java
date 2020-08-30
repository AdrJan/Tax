package lib.manager.logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Class for logging things that happens during execution of test.
 *
 * @author adrianjankowski
 */

public class TaxLogger {

    private static Logger log = LogManager.getLogger(TaxLogger.class);

    public static void testStarts() {
        testClosure("TEST STARTS");
    }

    public static void testEnds() {
        testClosure("TEST ENDS");
    }

    public static void info(String infoMsg) {
        log.info(infoMsg);
    }

    private static void testClosure(String testClosure) {
        log.info("=================================================");
        log.info("=                                               =");
        log.info(String.format("=%43s    =", testClosure));
        log.info("=                                               =");
        log.info("=================================================");
    }
}
