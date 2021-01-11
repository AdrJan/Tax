package core.lib.elements.base_elements;

import core.lib.elements.BaseElement;
import core.lib.elements.interactions.Inputtable;
import core.lib.elements.interactions.Visible;

/**
 * Represantation of input as a class.
 *
 * @author adrianjankowski
 */

public class Input extends BaseElement implements Visible, Inputtable {

    public Input(String xpath) {
        super(xpath);
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
    public void type(String text) {
        taxAction.typeText(this, text);
    }
}
