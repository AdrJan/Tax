package core.lib.elements.interactions;

import core.lib.elements.BaseElement;

/**
 * Interface making web element formattable during usage. It lets you
 * change its xpath based on given format.
 *
 * @param <T> type of element (example: Button, Label...)
 * @author adrianjankowski
 */

public interface Formattable<T extends BaseElement> {
    T setFormat(String xpath);

    T fmtChange(String... changes);
}
