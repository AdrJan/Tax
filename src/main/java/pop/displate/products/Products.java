package pop.displate.products;

import lib.test_setup.TestBase;

/**
 * Page Object Pattern class representing page with displayed products.
 *
 * @author Adrian Jankowski
 */

public class Products extends TestBase {

    private static final String PRODUCT_FORMAT = "(//div[@class = 'displate-tile__image-wrapper'])[%d]";
    private static final String COLLECTION_FORMAT = "//div[@class = 'collection__title']//a[contains(., '%s')]";

    public void selectCollection(String collectionName) {
        taxAction.click(elX(String.format(COLLECTION_FORMAT, collectionName)));
    }

    public void selectProduct(int whichOne) {
        taxAction.click(elX(String.format(PRODUCT_FORMAT, whichOne)));
    }
}
