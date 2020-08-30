package pop.automation_practice.products;

import lib.elements.base_elements.Button;
import lib.elements.base_elements.Label;
import lib.test_setup.TestBase;
import utils.Formatter;

public class CartList extends TestBase {

    Button cartButton = new Button("//a[contains(., 'Cart')]");
    Label shippingCostLabel = new Label("//span[contains(@class, 'cart_block_shipping_cost')]");
    Label totalCostLabel = new Label("//span[contains(@class, 'cart_block_total')]");

    public CartList expandCart() {
        cartButton.hover();
        return this;
    }

    public Double getShippingCost() {
        return Formatter.formatToDouble(shippingCostLabel.getText());
    }

    public Double getTotalCost() {
        return Formatter.formatToDouble(totalCostLabel.getText());
    }
}
