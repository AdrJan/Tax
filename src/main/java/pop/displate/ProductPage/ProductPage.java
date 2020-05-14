package pop.displate.ProductPage;

import pop.displate.ProductPage.options.Finish;
import pop.displate.ProductPage.options.Frame;
import pop.displate.ProductPage.options.Size;
import lib.test_setup.TestBase;
import utils.Formatter;

/**
 * Page object pattern class representing page of product selected to buy.
 *
 * @author Adrian Jankowski
 */

public class ProductPage extends TestBase {

    private static final String SIZE_FORMAT = "//div[@class = 'choose-size']//h4[contains(text(), '%s')]/../..";
    private static final String FINISH_FRAME_FORMAT = "//input[@name='%s']/..//*[contains(text(), '%s')]/..";

    public void selectSize(Size size) {
        taxAction.click(elX(String.format(SIZE_FORMAT, size.getOptionName())));
    }

    public void selectFinish(Finish finish) {
        taxAction.click(elX(String.format(FINISH_FRAME_FORMAT, "displate-finish-r", finish.getOptionName())));
    }

    public void selectFrame(Frame frame) {
        taxAction.click(elX(String.format(FINISH_FRAME_FORMAT, "displate-frame", frame.getOptionName())));
    }

    public void addToCart() {
        taxAction.click(elX("//button[contains(., 'Add to cart') and contains(@class, 'button--primary')]"));
    }

    public void proceedToCart() {
        taxAction.click(elX("//a[contains(., 'Proceed to cart')]"));
    }

    public Double getPrice() {
        return Formatter.getFormattedPrice(taxAction.getText(elX("//div[@class = 'add-to-cart-button-container']//span")));
    }
}
