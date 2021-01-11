package pop.automation_practice;

import core.lib.elements.base_elements.Button;
import core.lib.test_setup.TestBase;
import io.qameta.allure.Step;
import pop.automation_practice.products.ProductsSorting;

/**
 * POP class representing page with all products.
 *
 * @author Adrian Jankowski
 */

public class ProductsPage extends TestBase {

    Button sortingButton = new Button("//select[@id = 'selectProductSort']/..");
    Button productLabel = new Button().setFormat("//option[@value = '%s']");

    @Step("User sets product sorting.")
    public ProductsPage setSorting(ProductsSorting productsSorting) {
        sortingButton.click();
        productLabel.fmtChange(productsSorting.getOptionValue());
        return this;
    }
}
