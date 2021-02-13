package pop.automation_practice.products;

import core.lib.elements.base_elements.Button;
import core.lib.test_base.TestBase;
import io.qameta.allure.Step;

/**
 * POP class representing box after adding product to shopping cart.
 *
 * @author Adrian Jankowski
 */

public class AddedItemSummary extends TestBase {

    Button continueButton = new Button("//span[contains(., 'Continue shopping')]");

    @Step("User continue shopping.")
    public void continueShopping() {
        continueButton.click();
    }
}
