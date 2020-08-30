package lib.manager.driver_manager;

import org.openqa.selenium.WebDriver;

/**
 * Basic implementation of DriverManager.
 *
 * @author adrianjankowski
 */

public abstract class DriverManager {

    protected WebDriver driver;

    public abstract void createWebDriver();

    public WebDriver getWebDriver() {
        if (driver == null) {
            createWebDriver();
        }
        return driver;
    }

    public void quitWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
