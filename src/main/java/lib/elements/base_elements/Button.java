package lib.elements.base_elements;

import lib.elements.BaseElement;
import lib.elements.interactions.Clickable;
import lib.elements.interactions.Hoverable;
import lib.manager.logger.TaxLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Button extends BaseElement implements Hoverable, Clickable {

    private int RETRY_COUNT = 3;

    public Button(String xpath) {
        super(el(xpath), xpath);
    }

    @Override
    public void click() {
        TaxLogger.info("Clicking on element with xpath -> " + this.getXpath());
        for (int i = 0; i < RETRY_COUNT; i++) {
            try {
                taxWait.waitFor(ExpectedConditions.elementToBeClickable(this.getWE()));
                this.getWE().click();
                break;
            } catch (Exception e) {
                this.setWE(driver.findElement(By.xpath(this.getXpath())));
            }
            if (i == RETRY_COUNT - 1) {
                this.getWE().click();
            }
        }
        taxWait.waitForNoAjaxPending();
        taxWait.sleep(500);
    }

    @Override
    public void hover() {
        taxAction.hover(this);
        taxWait.sleep(500);
    }

    @Override
    public void moveTo() {
        taxAction.scrollIntoView(this);
        taxWait.sleep(500);
    }
}
