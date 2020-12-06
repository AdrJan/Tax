package lib.elements.base_elements;

import lib.elements.BaseElement;
import lib.elements.interactions.Formattable;
import lib.elements.interactions.Textable;
import lib.elements.interactions.Visible;

/**
 * Represantation of label as a class.
 *
 * @author adrianjankowski
 */

public class Label extends BaseElement implements Visible, Textable, Formattable<Label> {

    public Label(String xpath) {
        super(xpath);
    }

    public Label() {
        super(null);
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
    public Label fmtChange(String... changes) {
        String xpath = String.format(xpathFormat, changes);
        setWE(el(xpath));
        setXpath(xpath);
        return this;
    }
}
