package pop.automation_practice.products;

import lib.elements.base_elements.Button;
import lib.elements.base_elements.Label;
import lib.test_setup.TestBase;
import org.openqa.selenium.WebElement;
import utils.Formatter;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
        productContainerLabel.fmtChange(productName);
        productContainerLabel.hover();
        return this;
    }

    public ItemTile addToCart(String productName) {
        addToCartButton.fmtChange(productName);
        addToCartButton.click();
        return this;
    }

    public Double getPrice(String productName) {
        priceLabel.fmtChange(productName);
        return Formatter.formatToDouble(priceLabel.getText());
    }

    public Double getPrice(WebElement webElement) {
        return Formatter.formatToDouble(textElx(webElement));
    }

    public ArrayList<Double> getAllProductsPrices() {
        priceLabel.fmtChange("");
        return (ArrayList<Double>) ell(priceLabel.getXpath())
                .stream()
                .map(this::getPrice)
                .collect(Collectors.toList());
    }
}
