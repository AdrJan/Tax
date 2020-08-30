package lib.manager.driver_manager;

/**
 * Basic implementation of DriverManagerFactory.
 * Class for choosing between different browsers.
 *
 * @author adrianjankowski
 */

public class DriverManagerFactory {

    public static DriverManager getDriver(Browsers browser) {
        DriverManager driverManager;

        switch (browser) {
            default:
                driverManager = new ChromeDriverManager();
                break;
        }

        return driverManager;
    }
}
