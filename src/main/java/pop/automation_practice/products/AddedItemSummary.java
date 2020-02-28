package pop.automation_practice.products;

import test_setup.TestBase;

/**
 * POP class representing box after adding product to shopping cart.
 *
 * @author Adrian Jankowski
 */

public class AddedItemSummary extends TestBase {

    public void continueShopping() {
        taxAction.click(elX("//span[contains(., 'Continue shopping')]"));
    }
}
