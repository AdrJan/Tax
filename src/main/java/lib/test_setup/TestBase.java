package lib.test_setup;

import lib.actions.TaxAction;
import lib.actions.TaxAssert;
import lib.actions.TaxWait;
import lib.elements.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Wrapped webdriver basic methods for easier usage.
 *
 * @author Adrian Jankowski
 */

public class TestBase {

    protected static WebDriver driver;
    protected static TaxAction taxAction;
    protected static TaxAssert taxAssert;
    protected static TaxWait taxWait;

    protected static BaseElement elX(String xpath) {
        return new BaseElement(el(xpath), xpath);
    }

    protected static WebElement el(String xpath) {
        //taxWait.waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return driver.findElement(By.xpath(xpath));
    }

    protected static List<WebElement> ell(String xpath) {
        taxWait.waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return driver.findElements(By.xpath(xpath));
    }

    protected static void openPage(String url) {
        driver.get(url);
        taxWait.waitForNoAjaxPending();
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

    protected static void submitTextElx(BaseElement baseElement, String text) {
        typeTextElx(baseElement.getWE(), text);
        baseElement.getWE().sendKeys(Keys.ENTER);
    }
}
