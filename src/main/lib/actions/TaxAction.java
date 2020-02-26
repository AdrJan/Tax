package actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import test_setup.TestBase;

import java.util.concurrent.TimeUnit;

/**
 * Class with basic actions on page for all possible POPs.
 */

public class TaxAction extends TestBase {

    static Actions actions = new Actions(driver);

    public void click(WebElement element) {
        waitFor(ExpectedConditions.elementToBeClickable(element));
        element.click();
        waitForNoAjaxPending();
    }

    public void hover(WebElement element) {
        actions.moveToElement(element).perform();
    }

    public void typeText(WebElement element, String text) {
        element.clear();
        actions.sendKeys(element, text).perform();
    }

    public void assertXpath(String xpath) {
        Assert.assertTrue(
            ellX(xpath).size() > 0,
            "Assert for xpath: " + xpath
        );
    }

    public void waitFor(ExpectedCondition<?> expectedCondition) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(expectedCondition);
    }

    public void waitForNoAjaxPending() {
        waitFor(driver -> ((JavascriptExecutor)driver)
                .executeScript("return document.readyState")
                .equals("complete"));
    }

    public void sleep(int milliseconds) {
        driver.manage().timeouts().implicitlyWait(milliseconds, TimeUnit.MILLISECONDS);
    }
}
