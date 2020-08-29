package lib.actions;

import lib.elements.BaseElement;
import lib.manager.logger.TaxLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class with basic actions on page for all possible POPs.
 *
 * @author Adrian Jankowski
 */

public class TaxAction extends Actions {

    private int RETRY_COUNT = 3;

    private WebDriver driver;
    private TaxWait taxWait;

    public TaxAction(WebDriver driver) {
        super(driver);
        this.driver = driver;
        taxWait = new TaxWait(driver);
    }

    public void click(BaseElement baseElement) {
        TaxLogger.info("Clicking on element with xpath -> " + baseElement.getXpath());
        for (int i = 0; i < RETRY_COUNT; i++) {
            try {
                taxWait.waitFor(ExpectedConditions.elementToBeClickable(baseElement.getWE()));
                baseElement.getWE().click();
                break;
            } catch (Exception e) {
                baseElement.setWE(driver.findElement(By.xpath(baseElement.getXpath())));
            }
            if (i == RETRY_COUNT - 1) {
                baseElement.getWE().click();
            }
        }
        taxWait.waitForNoAjaxPending();
        taxWait.sleep(500);
    }

    public void scrollIntoView(BaseElement baseElement) {
        TaxLogger.info("Scroll into view -> " + baseElement.getXpath());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baseElement.getWE());
    }

    public void hover(BaseElement baseElement) {
        TaxLogger.info("Hover -> " + baseElement.getXpath());
        for (int i = 0; i < RETRY_COUNT; i++) {
            try {
                taxWait.waitFor(ExpectedConditions.visibilityOf(baseElement.getWE()));
                this.moveToElement(baseElement.getWE()).perform();
                break;
            } catch (Exception e) {
                baseElement.setWE(driver.findElement(By.xpath(baseElement.getXpath())));
            }
            if (i == RETRY_COUNT - 1) {
                this.moveToElement(baseElement.getWE()).perform();
            }
        }
        taxWait.sleep(500);
    }

    public void typeText(BaseElement baseElement, String text) {
        TaxLogger.info("Type text: '" + text + "' on -> " + baseElement.getXpath());
        for (int i = 0; i < RETRY_COUNT; i++) {
            try {
                taxWait.waitFor(ExpectedConditions.visibilityOf(baseElement.getWE()));
                baseElement.getWE().clear();
                sendKeys(baseElement.getWE(), text).perform();
                break;
            } catch (Exception e) {
                baseElement.setWE(driver.findElement(By.xpath(baseElement.getXpath())));
            }
            if (i == RETRY_COUNT - 1) {
                baseElement.getWE().clear();
                sendKeys(baseElement.getWE(), text).perform();
            }
        }
        taxWait.sleep(500);
    }

    public String getText(BaseElement baseElement) {
        for (int i = 0; i < RETRY_COUNT; i++) {
            try {
                taxWait.waitFor(ExpectedConditions.visibilityOf(baseElement.getWE()));
                return baseElement.getWE().getText();
            } catch (Exception e) {
                baseElement.setWE(driver.findElement(By.xpath(baseElement.getXpath())));
            }
        }
        return baseElement.getWE().getText();
    }
}
