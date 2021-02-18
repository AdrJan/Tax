package pop.automation_practice;

import core.lib.elements.base_elements.Button;
import io.qameta.allure.Step;
import pop.automation_practice.products.ProductsSorting;

/**
 * POP class representing page with all products.
 *
 * @author Adrian Jankowski
 */

public class ProductsPage {

    Button sortingButton = new Button("//select[@id = 'selectProductSort']/..");
    Button productLabel = new Button().setFormat("//option[@value = '%s']");

    @Step("User sets product sorting.")
    public void setSorting(ProductsSorting productsSorting) {
        sortingButton.click();
        productLabel.fmtChange(productsSorting.getOptionValue());
    }
}
