package lib.elements;

import lib.test_setup.TestBase;
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

    public BaseElement(WebElement webElement, String xpath) {
        this.xpath = xpath;
        this.webElement = webElement;
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
