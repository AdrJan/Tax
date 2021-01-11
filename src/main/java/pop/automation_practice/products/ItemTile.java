package pop.automation_practice.products;

import core.lib.elements.base_elements.Button;
import core.lib.elements.base_elements.Label;
import core.lib.test_setup.TestBase;
import core.utils.Formatter;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Pop class representing shop item.
 *
 * @author adrianjankowski
 */

public class ItemTile extends TestBase {

    private static final String PRODUCT_A_XPATH = "//a[@class = 'product-name' and contains(text(), '%s')]";

    Button addToCartButton = new Button().setFormat(PRODUCT_A_XPATH + "/../..//a[@title = 'Add to cart']");
    Label productContainerLabel = new Label().setFormat(PRODUCT_A_XPATH + "/../..");
    Label priceLabel = new Label().setFormat(PRODUCT_A_XPATH + "/../..//span[@itemprop = 'price']");

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
        return Formatter.formatToDouble(sw.textElx(webElement));
    }

    @Step("All products prices are checked.")
    public List<Double> getAllProductsPrices() {
        priceLabel.fmtChange("");
        return sw.ell(priceLabel.getXpath())
                .stream()
                .map(this::getPrice)
                .collect(Collectors.toList());
    }
}
