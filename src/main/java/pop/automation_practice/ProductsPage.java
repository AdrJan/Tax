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

    static Button sortingButton = new Button("//select[@id = 'selectProductSort']/..");

    private final String PRODUCT_LABEL_FORMAT = "//option[@value = '%s']";

    public ProductsPage setSorting(ProductsSorting productsSorting) {
        sortingButton.click();
        new Button(String.format(PRODUCT_LABEL_FORMAT, productsSorting.getOptionValue())).click();
        return this;
    }
}
