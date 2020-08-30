package pop.automation_practice;

import lib.elements.base_elements.Button;
import lib.test_setup.TestBase;
import pop.automation_practice.products.ProductsSorting;

/**
 * POP class representing page with all products.
 *
 * @author Adrian Jankowski
 */

public class ProductsPage extends TestBase {

    Button sortingButton = new Button("//select[@id = 'selectProductSort']/..");
    Button productLabel = new Button().setFormat("//option[@value = '%s']");

    public ProductsPage setSorting(ProductsSorting productsSorting) {
        sortingButton.click();
        productLabel.fmtChange(productsSorting.getOptionValue());
        return this;
    }
}
