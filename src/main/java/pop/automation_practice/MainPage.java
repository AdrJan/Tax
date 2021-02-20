package pop.automation_practice;

import core.lib.elements.base_elements.Button;
import core.lib.elements.base_elements.Input;
import core.lib.testbase.TestBase;

/**
 * POP - Main Page.
 *
 * @author Adrian Jankowski
 */

public class MainPage extends TestBase {

    static Input searchInput = new Input("//input[contains(@class, 'search_query')]");
    static Button searchButton = new Button("//button[@name = 'submit_search']");

    public void verifyIfIsDisplayed() {
        taxAssert.assertXpath(
                "//div[@id = 'page']",
                "Main page is not displayed"
        );
    }

    public void searchFor(String text) {
        searchInput.type(text);
        searchButton.click();
    }
}
