package pop.automation_practice.products;

import core.lib.elements.base_elements.Button;
import core.lib.elements.base_elements.Label;
import core.lib.test_setup.TestBase;
import core.utils.Formatter;
import io.qameta.allure.Step;

public class CartList extends TestBase {

    Button cartButton = new Button("//a[contains(., 'Cart')]");
    Label shippingCostLabel = new Label("//span[contains(@class, 'cart_block_shipping_cost')]");
    Label totalCostLabel = new Label("//span[contains(@class, 'cart_block_total')]");

    @Step("User expands shopping cart.")
    public CartList expandCart() {
        cartButton.hover();
        return this;
    }

    @Step("Shipping cost is checked.")
    public Double getShippingCost() {
        return Formatter.formatToDouble(shippingCostLabel.getText());
    }

    @Step("Total cost is checked.")
    public Double getTotalCost() {
        return Formatter.formatToDouble(totalCostLabel.getText());
    }
}
