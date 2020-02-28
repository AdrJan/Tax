package pop.automation_practice;

import pop.automation_practice.products.ProductsSorting;
import test_setup.TestBase;

/**
 * POP class representing page with all products.
 *
 * @author Adrian Jankowski
 */

public class ProductsPage extends TestBase {

    private final String PRODUCT_LABEL_FORMAT = "//option[@value = '%s']";

    public ProductsPage setSorting(ProductsSorting productsSorting) {
        taxAction.click(elX("//select[@id = 'selectProductSort']/.."));
        taxAction.click(elX(String.format(PRODUCT_LABEL_FORMAT, productsSorting.getOptionValue())));
        return this;
    }
}
