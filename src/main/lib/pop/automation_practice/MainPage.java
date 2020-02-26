package pop.automation_practice;

import test_setup.TestBase;

/**
 * POP - Main Page.
 *
 * @author Adrian Jankowski
 */

public class MainPage extends TestBase {

    public MainPage searchFor(String text) {
        taxAction.typeText(elX("//input[contains(@class, 'search_query')]"), text);
        taxAction.click(elX("//button[@name = 'submit_search']"));
        return this;
    }


}
