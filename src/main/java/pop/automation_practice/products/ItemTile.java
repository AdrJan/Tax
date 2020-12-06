package pop.automation_practice.products;

import io.qameta.allure.Step;
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

    @Step("User hovers mouse above product {0}.")
    public ItemTile hoverProduct(String productName) {
        productContainerLabel.fmtChange(productName);
        productContainerLabel.hover();
        return this;
    }

    @Step("User adds product {0} to cart.")
    public ItemTile addToCart(String productName) {
        addToCartButton.fmtChange(productName);
        addToCartButton.click();
        return this;
    }

    @Step("Product {0} price is checked.")
    public Double getPrice(String productName) {
        priceLabel.fmtChange(productName);
        return Formatter.formatToDouble(priceLabel.getText());
    }

    public Double getPrice(WebElement webElement) {
        return Formatter.formatToDouble(textElx(webElement));
    }

    @Step("All products prices are checked.")
    public ArrayList<Double> getAllProductsPrices() {
        priceLabel.fmtChange("");
        return (ArrayList<Double>) ell(priceLabel.getXpath())
                .stream()
                .map(this::getPrice)
                .collect(Collectors.toList());
    }
}
