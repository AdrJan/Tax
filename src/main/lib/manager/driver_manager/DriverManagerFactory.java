package manager.driver_manager;

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
