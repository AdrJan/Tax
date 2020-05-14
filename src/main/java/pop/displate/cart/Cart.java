package pop.displate.cart;

import lib.test_setup.TestBase;
import utils.Formatter;

/**
 * Page Object Pattern class representing shopping cart.
 *
 * @author Adrian Jankowski
 */

public class Cart extends TestBase {

    private final String COUNTRY_FORMAT = "//div[@class = 'input-select__item' and contains(text(), '%s')]";

    public void selectCountry(String countryName) {
        taxAction.click(elX("//div[@id='select-country']"));

        taxAction.scrollIntoView(elX(String.format(COUNTRY_FORMAT, countryName)));
        taxAction.click(elX(String.format(COUNTRY_FORMAT, countryName)));
    }

    public void applyDiscountCodeInput(String code) {
        openDiscountCodeInput();
        setDiscountCodeInput(code);
        taxAction.click(elX("//input[@id='discount-apply']"));
    }

    public void openDiscountCodeInput() {
        taxAction.click(elX("//div[contains(text(), 'I have a discount code')]"));
    }

    public void setDiscountCodeInput(String code) {
        taxAction.typeText(elX("//input[@id='discount-code']"), code);
    }

    public double getTotalCost() {
        return Formatter.getFormattedPrice(taxAction.getText(elX("//span[@id = 'total-cost']")));
    }

    public double getShipmentCost() {
        return Formatter.getFormattedPrice(taxAction.getText(elX("//span[@id = 'shipment-amount']")));
    }

    public double getCartCost() {
        return Formatter.getFormattedPrice(taxAction.getText(elX("//span[@id = 'cart-total']")));
    }
}
