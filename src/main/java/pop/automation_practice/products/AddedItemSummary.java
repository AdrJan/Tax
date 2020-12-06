package pop.automation_practice.products;

import io.qameta.allure.Step;
import lib.elements.base_elements.Button;
import lib.test_setup.TestBase;

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
