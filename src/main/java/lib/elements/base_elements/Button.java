package lib.elements.base_elements;

import lib.elements.BaseElement;
import lib.elements.interactions.Clickable;
import lib.elements.interactions.Formattable;
import lib.elements.interactions.Visible;

/**
 * Representation of button as a class.
 *
 * @author adrianjankowski
 */

public class Button extends BaseElement implements Visible, Clickable, Formattable<Button> {

    public Button(String xpath) {
        super(el(xpath), xpath);
    }

    public Button() {
        super(null, null);
    }

    @Override
    public void click() {
        taxAction.click(this);
    }

    @Override
    public void hover() {
        taxAction.hover(this);
    }

    @Override
    public void moveTo() {
        taxAction.scrollIntoView(this);
    }

    @Override
    public Button setFormat(String xpathFormat) {
        this.xpathFormat = xpathFormat;
        return this;
    }

    @Override
    public Button fmtChange(String... changes) {
        String xpath = String.format(xpathFormat, changes);
        setWE(el(xpath));
        setXpath(xpath);
        return this;
    }
}
