package core.lib.actions;

import core.lib.manager.logger.TaxLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaxWait {

    private final WebDriver driver;

    public TaxWait(WebDriver driver) {
        this.driver = driver;
    }

    public void waitFor(ExpectedCondition<?> expectedCondition) {
        new WebDriverWait(driver, 20).until(expectedCondition);
    }

    public void waitForNoAjaxPending() {
        TaxLogger.info("Wait for no Ajax pending");
        waitFor(d -> ((JavascriptExecutor) d)
                .executeScript("return document.readyState")
                .equals("complete"));
        waitFor(d -> ((JavascriptExecutor) d)
                .executeScript("return jQuery.active == 0"));
    }

    public void sleep(long milliseconds) {
        TaxLogger.info("Sleep for " + milliseconds + " milliseconds");
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
