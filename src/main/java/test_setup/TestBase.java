package test_setup;

import actions.TaxAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 *  Wrapped webdriver methods for easier usage.
 *
 * @author Adrian Jankowski
 * */

public class TestBase {

    protected static WebDriver driver;
    protected static TaxAction taxAction;

    protected static WebElement elX(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    protected static List<WebElement> ellX(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    protected static void openPage(String url) {
        driver.get(url);
    }

    protected static String getTitle() {
        return driver.getTitle();
    }

    protected static String textElx(String xpath) {
        return elX(xpath).getAttribute("innerText");
    }

    protected static String textElx(WebElement webElement) {
        return webElement.getAttribute("innerText");
    }
}
