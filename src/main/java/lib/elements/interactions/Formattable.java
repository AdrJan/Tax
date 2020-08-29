package lib.elements.interactions;

import lib.elements.BaseElement;

public interface Formattable<T extends BaseElement> {
    T setFormat(String xpath);

    T change(String... change);
}
