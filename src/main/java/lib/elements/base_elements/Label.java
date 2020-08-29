package lib.elements.base_elements;

import lib.elements.BaseElement;
import lib.elements.interactions.Formattable;
import lib.elements.interactions.Hoverable;
import lib.elements.interactions.Textable;

public class Label extends BaseElement implements Hoverable, Textable, Formattable<Label> {


    public Label(String xpath) {
        super(el(xpath), xpath);
    }

    public Label() {
        super(null, null);
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
    public String getText() {
        return taxAction.getText(this);
    }

    @Override
    public Label setFormat(String xpathFormat) {
        this.xpathFormat = xpathFormat;
        return this;
    }

    @Override
    public Label change(String... change) {
        String xpath = String.format(xpathFormat, change);
        setWE(el(xpath));
        setXpath(xpath);
        return this;
    }
}
