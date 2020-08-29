package pop.automation_practice.products;

import lib.elements.base_elements.Button;
import lib.elements.base_elements.Label;
import lib.test_setup.TestBase;
import org.openqa.selenium.WebElement;
import utils.Formatter;

/**
 * Pop class representing shop item.
 *
 * @author adrianjankowski
 */

public class ItemTile extends TestBase {

    Button addToCartButton = new Button().setFormat("//a[@class = 'product-name' and contains(text(), '%s')]" +
            "/../..//a[@title = 'Add to cart']");
    Label productContainerLabel = new Label().setFormat("//a[@class = 'product-name' and contains(text(), '%s')]" +
            "/../..");
    Label priceLabel = new Label().setFormat("//a[@class = 'product-name' and contains(text(), '%s')]" +
            "/../..//span[@itemprop = 'price']");


    public ItemTile hoverProduct(String productName) {
        productContainerLabel.change(productName);
        productContainerLabel.hover();
        return this;
    }

    public ItemTile addToCart(String productName) {
        addToCartButton.change(productName);
        addToCartButton.click();
        return this;
    }

    public Double getPrice(String productName) {
        priceLabel.change(productName);
        return Formatter.formatToDouble(priceLabel.getText());
    }

    public Double getPrice(WebElement webElement) {
        return Formatter.formatToDouble(textElx(webElement));
    }

//    public ArrayList<Double> getAllProductsPrices() {
//        priceLabel.change("");
//        return (ArrayList<Double>) ell(String.format(PRICE_LABEL_FORMAT, ""))
//                .stream()
//                .map(this::getPrice)
//                        .collect(Collectors.toList());
//    }
}
