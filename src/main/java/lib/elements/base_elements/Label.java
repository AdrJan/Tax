package lib.elements.base_elements;

import lib.elements.BaseElement;
import lib.elements.interactions.Hoverable;
import lib.elements.interactions.Textable;

public class Label extends BaseElement implements Hoverable, Textable {

    public Label(String xpath) {
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
    public String getText() {
        return taxAction.getText(this);
    }
}
