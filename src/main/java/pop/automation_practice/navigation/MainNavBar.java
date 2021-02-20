package pop.automation_practice.navigation;

import core.lib.elements.base_elements.Button;
import core.lib.testbase.TestBase;

/**
 * Page object pattern class for main navigation bar.
 *
 * @author Adrian Jankowski
 */

public class MainNavBar extends TestBase {

    private final Button menuItemButton = new Button().setFormat("//div[@id='block_top_menu']" +
            "//ul[contains(@class, 'menu-content')]/li/a[@title='%s']");

    public void chooseMenuItem(String menuItem) {
        menuItemButton.fmtChange(menuItem);
        menuItemButton.click();
    }
}
