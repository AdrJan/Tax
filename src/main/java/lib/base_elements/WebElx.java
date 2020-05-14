package lib.base_elements;

import org.openqa.selenium.WebElement;

/**
 * Wrapper for WebElement -> WebElement containing its XPath.
 *
 * @author Adrian Jankowski
 */

public class WebElx {

    private String xpath;
    private WebElement webElement;

    public WebElx(WebElement webElement, String xpath) {
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
}
