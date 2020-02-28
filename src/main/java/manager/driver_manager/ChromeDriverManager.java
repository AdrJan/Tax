package manager.driver_manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {
    private final static String PATH_TO_DRIVER = "src/main/resources/drivers/chromedriver";

    public void createWebDriver() {
        System.setProperty("webdriver.chrome.driver", PATH_TO_DRIVER);
        ChromeOptions options = new ChromeOptions();
        this.driver = new ChromeDriver(options);
    }
}
