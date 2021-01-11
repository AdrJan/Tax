package pop.automation_practice;

import core.lib.elements.base_elements.Button;
import core.lib.elements.base_elements.Input;
import core.lib.test_setup.TestBase;
import io.qameta.allure.Step;

/**
 * POP - Main Page.
 *
 * @author Adrian Jankowski
 */

public class MainPage extends TestBase {

    static Input searchInput = new Input("//input[contains(@class, 'search_query')]");
    static Button searchButton = new Button("//button[@name = 'submit_search']");

    @Step("User is searching for {0}.")
    public MainPage searchFor(String text) {
        searchInput.type(text);
        searchButton.click();
        return this;
    }
}
