package core.lib.elements.base_elements;

import core.lib.elements.BaseElement;
import core.lib.elements.interactions.Formattable;
import core.lib.elements.interactions.Textable;
import core.lib.elements.interactions.Visible;

/**
 * Representation of label as a class.
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
        setWE(sw.el(xpath));
        setXpath(xpath);
        return this;
    }
}
