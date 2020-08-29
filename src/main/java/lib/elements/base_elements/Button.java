package lib.elements.base_elements;

import lib.elements.BaseElement;
import lib.elements.interactions.Clickable;
import lib.elements.interactions.Formattable;
import lib.elements.interactions.Hoverable;

public class Button extends BaseElement implements Hoverable, Clickable, Formattable<Button> {

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
    public Button change(String... change) {
        String xpath = String.format(xpathFormat, change);
        setWE(el(xpath));
        setXpath(xpath);
        return this;
    }
}
