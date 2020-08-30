package pop.automation_practice;

import lib.elements.base_elements.Button;
import lib.elements.base_elements.Input;
import lib.test_setup.TestBase;

/**
 * POP - Main Page.
 *
 * @author Adrian Jankowski
 */

public class MainPage extends TestBase {

    static Input searchInput = new Input("//input[contains(@class, 'search_query')]");
    static Button searchButton = new Button("//button[@name = 'submit_search']");

    public MainPage searchFor(String text) {
        searchInput.type(text);
        searchButton.click();
        return this;
    }
}
