package pop.automation_practice.navigation;

import core.lib.elements.base_elements.Button;
import core.lib.testbase.TestBase;
import io.qameta.allure.Step;

/**
 * Page object pattern class for main navigation bar.
 *
 * @author Adrian Jankowski
 */

public class MainNavBar extends TestBase {

    Button menuItem = new Button().setFormat("//div[@id='block_top_menu']" +
            "//ul[contains(@class, 'menu-content')]/li/a[@title='%s']");

    @Step("User is choosing option from main menu.")
    public void chooseMenuItem(MainNavItems mainNavItems) {
        menuItem.fmtChange(mainNavItems.getLabel());
        menuItem.click();
    }
}




