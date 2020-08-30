package lib.test_setup;

import lib.actions.TaxAction;
import lib.actions.TaxAssert;
import lib.actions.TaxWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Wrapped webdriver basic methods for easier usage.
 *
 * @author adrianjankowski
 */

public class TestBase {

    protected static WebDriver driver;
    protected static TaxAction taxAction;
    protected static TaxAssert taxAssert;
    protected static TaxWait taxWait;

    protected static WebElement el(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    protected static List<WebElement> ell(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    protected static void openPage(String url) {
        driver.get(url);
    }

    protected static String getTitle() {
        return driver.getTitle();
    }

    protected static String getUrl() {
        return driver.getCurrentUrl();
    }

    protected static String textElx(WebElement webElement) {
        return webElement.getAttribute("innerText");
    }
}
