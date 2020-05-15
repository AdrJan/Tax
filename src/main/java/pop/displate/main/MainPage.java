package pop.displate.main;

import lib.test_setup.TestBase;

public class MainPage extends TestBase {

    final static String PRODUCT_FORMAT = "(//h3[contains(text(), '%s')]/.." +
            "//div[@class = 'displate-tile__image-wrapper'])[%d]";


    public void selectProduct(ProductCategory productCategory, int whichOne) {
        taxAction.click(elX(String.format(PRODUCT_FORMAT, productCategory.getName(), whichOne)));
    }

    public void goToSpecialOffer() {
        taxAction.click(elX("//div[contains(@class, 'homepage-banner')]/a"));
    }

    public void closeCookiePopup() {
        taxAction.click(elX("//div[contains(@class, 'cookie-container')]//button"));
    }
}
