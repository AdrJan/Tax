package core.lib.elements;

import core.lib.testbase.TestBase;
import org.openqa.selenium.WebElement;

/**
 * Wrapper for WebElement -> WebElement containing its XPath.
 *
 * @author adrianjankowski
 */

public class BaseElement extends TestBase {

    private String xpath;
    protected String xpathFormat;
    private WebElement webElement;

    public BaseElement(String xpath) {
        this.xpath = xpath;
    }

    public WebElement getWE() {
        return webElement;
    }

    public void setWE(WebElement webElement) {
        this.webElement = webElement;
    }

    public String getXpath() {
        return xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }
}
