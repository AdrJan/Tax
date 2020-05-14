package pop.automation_practice.products;

import lib.test_setup.TestBase;
import utils.Formatter;

public class CartList extends TestBase {

    public CartList expandCart() {
        taxAction.click(elX("//a[contains(., 'Cart')]"));
        return this;
    }

    public Double getShippingCost() {
        return Formatter.getFormattedPrice(textElx("//span[contains(@class, 'cart_block_shipping_cost')]"));
    }

    public Double getTotalCost() {
        return Formatter.getFormattedPrice(textElx("//span[contains(@class, 'cart_block_total')]"));
    }
}
