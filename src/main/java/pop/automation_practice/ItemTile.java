package pop.automation_practice;

import test_setup.TestBase;
import utils.Formatter;

/**
 * Pop class representing shop item.
 *
 * @author adrianjankowski
 */

public class ItemTile extends TestBase {

    private final String ADD_TO_CART_BUTTON_FORMAT = "//a[@class = 'product-name' and contains(text(), '%s')]" +
            "/../..//a[@title = 'Add to cart']";
    private final String PRICE_LABEL_FORMAT = "//a[@class = 'product-name' and contains(text(), '%s')]" +
            "/../..//span[@itemprop = 'price']";
    private final String PRODUCT_CONTAINER_FORMAT = "//a[@class = 'product-name' and contains(text(), '%s')]" +
            "/../..";

    public ItemTile hoverProduct(String productName) {
        taxAction.hover(elX(String.format(PRODUCT_CONTAINER_FORMAT, productName)));
        return this;
    }

    public ItemTile addToCart(String productName) {
        taxAction.click(elX(String.format(ADD_TO_CART_BUTTON_FORMAT, productName)));
        return this;
    }

    public Double getPrice(String productName) {
        return Formatter.getFormattedPrice(textElx(String.format(PRICE_LABEL_FORMAT, productName)));
    }
}
