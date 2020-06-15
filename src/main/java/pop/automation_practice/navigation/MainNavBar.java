package pop.automation_practice.navigation;

import lib.test_setup.TestBase;

/**
 *  Page object pattern class for main navigation bar.
 *
 * @author Adrian Jankowski
 */

public class MainNavBar extends TestBase {

    private final static String MENU_ITEM_XPATH = "//div[@id='block_top_menu']" +
            "//ul[contains(@class, 'menu-content')]/li/a[@title='%s']";

    public void chooseMenuItem(MainNavItems mainNavItems) {
        taxAction.click(elX(String.format(MENU_ITEM_XPATH, mainNavItems.getLabel())));
    }

    public void chooseMenuItem(String menuLabel) {
        taxAction.click(elX(String.format(MENU_ITEM_XPATH, menuLabel)));
    }
}




