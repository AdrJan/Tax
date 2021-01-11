package core.lib.manager.driver_manager;

/**
 * Basic implementation of DriverManagerFactory.
 * Class for choosing between different browsers.
 *
 * @author adrianjankowski
 */

public class DriverManagerFactory {

    private DriverManagerFactory() {

    }

    public static DriverManager getDriver(Browsers browser) {
        DriverManager driverManager;

        switch (browser) {
            case FIREFOX:
                throw new UnsupportedOperationException();
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            default:
                throw new UnsupportedOperationException();
        }

        return driverManager;
    }
}
