package lib.actions;

import lib.base_elements.WebElx;
import lib.test_setup.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Class with basic actions on page for all possible POPs.
 *
 * @author Adrian Jankowski
 */

public class TaxAction extends TestBase {

    static Actions actions = new Actions(driver);

    private static final int RETRY_COUNT = 3;
    private static final double DELTA = 0.001;

    //TODO: move RETRY_COUNT to config file
    public void click(WebElx webElx) {
        for(int i = 0; i < RETRY_COUNT; i++) {
            try {
                waitFor(ExpectedConditions.elementToBeClickable(webElx.getWE()));
                webElx.getWE().click();
                break;
            } catch(Exception e) {
                webElx.setWE(driver.findElement(By.xpath(webElx.getXpath())));
            }
            //will throw unchecked exception
            if(i == RETRY_COUNT - 1) {
                webElx.getWE().click();
            }
        }

        waitForNoAjaxPending();
        sleep(500);
    }

    public void hover(WebElx webElx) {
        actions.moveToElement(webElx.getWE()).perform();
        sleep(500);
    }

    public void scrollIntoView(WebElx webElx) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElx.getWE());
    }

    public void typeText(WebElx webElx, String text) {
        webElx.getWE().clear();
        actions.sendKeys(webElx.getWE(), text).perform();
    }

    //TODO: Very rarely returns empty string, needs work
    public String getText(WebElx webElx) {
        sleep(1000);
        return textElx(webElx.getWE());
    }

    public void waitForNoAjaxPending() {
        waitFor(driver -> ((JavascriptExecutor)driver)
                .executeScript("return document.readyState")
                .equals("complete"));
        waitFor(driver -> ((JavascriptExecutor)driver)
                .executeScript("return jQuery.active == 0"));
    }

    public void waitFor(ExpectedCondition<?> expectedCondition) {
        new WebDriverWait(driver, 20).until(expectedCondition);
    }

    public void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void assertXpath(String xpath, String message) {
        Assert.assertTrue(
                ell(xpath).size() > 0,
                "Assert for xpath: " + xpath + "\n" + message
        );
    }

    public void assertTwoDoublesEqual(double double1, double double2) {
        Assert.assertEquals(
                double1, double2, DELTA
        );
    }
}