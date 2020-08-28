package lib.actions;

import lib.elements.BaseElement;
import lib.manager.logger.TaxLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Class with basic actions on page for all possible POPs.
 *
 * @author Adrian Jankowski
 */

public class TaxAction extends Actions {

    private WebDriver driver;

    public TaxAction(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void scrollIntoView(BaseElement baseElement) {
        TaxLogger.info("Scroll into view -> " + baseElement.getXpath());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baseElement.getWE());
    }

    public void typeText(BaseElement baseElement, String text) {
        TaxLogger.info("Type text: '" + text + "' on -> " + baseElement.getXpath());
        baseElement.getWE().clear();
        sendKeys(baseElement.getWE(), text).perform();
    }

    public String getText(BaseElement baseElement) {
        return baseElement.getWE().getAttribute("innerText");
    }

    public void hover(BaseElement baseElement) {
        TaxLogger.info("Hover -> " + baseElement.getXpath());
        moveToElement(baseElement.getWE()).perform();
    }
}
