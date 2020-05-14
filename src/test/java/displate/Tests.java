package displate;

import lib.test_setup.TestSetup;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pop.displate.MainPage.MainPage;
import pop.displate.ProductPage.ProductPage;
import pop.displate.ProductPage.ProductParameters;
import pop.displate.ProductPage.options.Assertable;
import pop.displate.ProductPage.options.Finish;
import pop.displate.ProductPage.options.Frame;
import pop.displate.ProductPage.options.Size;
import pop.displate.cart.Cart;
import pop.displate.products.Products;

/**
 * Class with all tests of page: https://displate.com
 *
 * @author Adrian Jankowski
 */

public class Tests extends TestSetup {

    private final static String PAGE_URL = "https://displate.com/";
    private final static double CONV_EURO_DOLLAR = 1.118;

    private final static String PRODUCT_PARAMETER_FORMAT = "//div[contains(@class, 'desk-cart-%s')]" +
            "//div[contains(@class, 'input-select__item--selected') and contains(text(), '%s')]";

    ProductParameters productParameters;

    @BeforeTest
    public void getProductParameters() {
        productParameters = new ProductParameters();
    }

    @Test(priority = 1)
    public void smokeTest() {
        openPage(PAGE_URL);
        new MainPage().closeCookiePopup();
        Assert.assertEquals("Displate - metal posters | Make Your Home Awesome", getTitle());
    }

    @Test(priority = 2)
    public void addProductToCart() {
        MainPage mainPage = new MainPage();
        ProductPage productPage = new ProductPage();
        Products products = new Products();
        Cart cart = new Cart();

        String discountCode = "Empire40";
        String collectionName = "Love Star Wars";
        String country = "United States";
        double discount = 40.0; //Discount in percents
        double priceProduct;
        String productHref;

        productParameters.setFinish(Finish.MATTE);
        productParameters.setFrame(Frame.NATURAL_WOOD_PATTERN);
        productParameters.setSize(Size.M);

        openPage(PAGE_URL);
        mainPage.closeCookiePopup();
        mainPage.goToSpecialOffer();
        products.selectCollection(collectionName);
        products.selectProduct(1);
        fillProductForm(productParameters);
        priceProduct = productPage.getPrice();
        productHref = getUrl();
        productPage.addToCart();
        productPage.proceedToCart();
        cart.selectCountry(country);
        cart.applyDiscountCodeInput(discountCode);
        priceProduct *= CONV_EURO_DOLLAR;
        checkProduct(productParameters, productHref);
        checkPrices(Math.round(priceProduct), cart.getCartCost(), discount);
    }

    //---- METHODS ----

    private void fillProductForm(ProductParameters productParameters) {
        ProductPage productPage = new ProductPage();
        productPage.selectSize(productParameters.getSize());
        productPage.selectFinish(productParameters.getFinish());
        productPage.selectFrame(productParameters.getFrame());
    }

    //---- ASSERTIONS ----

    private void checkProduct(ProductParameters productParameters, String productHref) {
        taxAction.assertXpath(
                String.format("//a[@href='%s']", productHref),
                "Wrong product on cart"
        );
        checkParametersOnCart(productParameters);
    }

    private void checkParametersOnCart(ProductParameters productParameters) {
        checkParameter(productParameters.getSize());
        checkParameter(productParameters.getFinish());
        checkParameter(productParameters.getFrame());
        checkParameter(productParameters.getQuantity());
    }

    private void checkParameter(Assertable assertable) {
        taxAction.assertXpath(
                String.format(PRODUCT_PARAMETER_FORMAT, assertable.getName(), assertable.getOptionName()),
                "Wrong " + assertable.getName() + "! Should be:" + assertable.getName()
        );
    }

    public void checkPrices(double priceProduct, double priceCartAfterDiscount, double discount) {
        taxAction.assertTwoDoublesEqual(
                priceProduct * ((100.0 - discount) / 100.0), priceCartAfterDiscount
        );
    }
}
