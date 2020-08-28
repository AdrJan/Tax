package lib.elements.base_elements;

import lib.elements.BaseElement;
import lib.elements.interactions.Hoverable;
import lib.elements.interactions.Inputtable;

public class Input extends BaseElement implements Hoverable, Inputtable {

    public Input(String xpath) {
        super(el(xpath), xpath);
    }

    @Override
    public void hover() {
        taxAction.hover(this);
        taxWait.sleep(500);
    }

    @Override
    public void moveTo() {
        taxAction.scrollIntoView(this);
        taxWait.sleep(500);
    }

    @Override
    public void type(String text) {
        taxAction.typeText(this, text);
    }
}
