package lib.test_setup;

import lib.actions.TaxAction;
import lib.actions.TaxAsserts;
import lib.base_elements.WebElx;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 *  Wrapped webdriver methods for easier usage.
 *
 * @author Adrian Jankowski
 */

public class TestBase {

    protected static WebDriver driver;
    protected static TaxAction taxAction;
    protected static TaxAsserts taxAsserts;

    protected static WebElx elX(String xpath) {
        return new WebElx(el(xpath), xpath);
    }

    protected static WebElement el(String xpath) {
        taxAction.waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return driver.findElement(By.xpath(xpath));
    }

    protected static List<WebElement> ell(String xpath) {
        taxAction.waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return driver.findElements(By.xpath(xpath));
    }

    protected static void openPage(String url) {
        driver.get(url);
        taxAction.waitForNoAjaxPending();
    }

    protected static String getTitle() {
        return driver.getTitle();
    }

    protected static String getUrl() {
        return driver.getCurrentUrl();
    }

    protected static String textElx(String xpath) {
        return elX(xpath).getWE().getText();
    }

    protected static String textElx(WebElement webElement) {
        return webElement.getAttribute("innerText");
    }

    protected static void typeTextElx(WebElement webElement, String text) {
        webElement.sendKeys(text);
    }

    protected static void typeTextElx(String xpath, String text) {
        elX(xpath).getWE().sendKeys(text);
    }

    protected static void submitTextElx(WebElx webElx, String text) {
        typeTextElx(webElx.getWE(), text);
        webElx.getWE().sendKeys(Keys.ENTER);
    }
}
