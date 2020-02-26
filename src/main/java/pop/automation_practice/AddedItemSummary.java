package pop.automation_practice;

import test_setup.TestBase;

public class AddedItemSummary extends TestBase {

    public void continueShopping() {
        taxAction.click(elX("//span[contains(., 'Continue shopping')]"));
    }
}
