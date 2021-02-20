package automation_practice;

import core.lib.testsetup.TestListener;
import core.lib.testsetup.TestSetup;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pop.automation_practice.MainPage;
import pop.automation_practice.ProductsPage;
import pop.automation_practice.navigation.MainNavBar;
import pop.automation_practice.products.AddedItemSummary;
import pop.automation_practice.products.CartList;
import pop.automation_practice.products.ItemTile;
import pop.automation_practice.products.ProductsSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Test class with all testcases for http://automationpractice.com/ site.
 *
 * @author Adrian Jankowski
 */

@Listeners(TestListener.class)
public class Tests extends TestSetup {

    private final static String PAGE_URL = "http://automationpractice.com/index.php";

    // *** TESTS ***

    @Test(priority = 2, description = "Checking if submenus are working correctly.")
    public void iterateThroughMenuItems() {
        String ASSERT_FORMAT = "//div[contains(@class, 'cat_desc') and contains(., '%s')]";
        MainNavBar mainNavBar = new MainNavBar();

        sw.openPage(PAGE_URL);
//        for (MainNavItems mainNavItem : MainNavItems.values()) {
//            mainNavBar.chooseMenuItem(mainNavItem);
//            taxAssert.assertXpath(
//                    String.format(ASSERT_FORMAT, mainNavItem.getLabel()),
//                    "Wrong item!"
//            );
//        }
    }

    @Test(priority = 3, description = "Adding product to shopping cart.")
    public void addToCart() {
        ItemTile itemTile = new ItemTile();
        AddedItemSummary addedItemSummary = new AddedItemSummary();
        CartList cartList = new CartList();

        double sum = 0.0;
        double totalCost;
        double shippingCost;

        ArrayList<String> products = new ArrayList<>(Arrays.asList(
                "Faded Short Sleeve T-shirts",
                "Printed Dress",
                "Blouse"
        ));

        sw.openPage(PAGE_URL);
//        new MainNavBar().chooseMenuItem(MainNavItems.WOMEN);
        for (String productName : products) {
            sum += itemTile.getPrice(productName);
            itemTile.hoverProduct(productName).addToCart(productName);
            addedItemSummary.continueShopping();
        }
        totalCost = cartList.expandCart().getTotalCost();
        shippingCost = cartList.getShippingCost();

        assertEquals(
                sum + shippingCost, totalCost,
                "Evaluated cost is not correct"
        );
    }

    @Test(priority = 4, description = "Searching for specific product.")
    public void searchForProducts() {
        MainPage mainPage = new MainPage();

        sw.openPage(PAGE_URL);

        ArrayList<String> products = new ArrayList<>(Arrays.asList("Blouse", "T-shirt", "Dress"));
        for (String product : products) {
            searchForSpecificProduct(mainPage, product);
        }
    }

    @Test(priority = 5, description = "Sorting products in ascended mode.")
    public void sortProductsPriceASC() {
        sw.openPage(PAGE_URL);
//        new MainNavBar().chooseMenuItem(MainNavItems.DRESSES);
        new ProductsPage().setSorting(ProductsSorting.PRICE_ASC);

        List<Double> allProductsPrices = new ItemTile().getAllProductsPrices();
        List<Double> allProductsPricesSorted = new ArrayList<>();
        Collections.copy(allProductsPrices, allProductsPricesSorted);
        Collections.sort(allProductsPricesSorted);

        assertEquals(
                allProductsPrices,
                allProductsPricesSorted,
                "Products are not sorted correctly"
        );
    }

    // *** METHODS ***

    private void searchForSpecificProduct(MainPage mainPage, String product) {
        String PRODUCT_ASSERT = "//ul[contains(@class, 'product_list')]" +
                "//a[@class = 'product-name' and contains(., '%s')]";
        mainPage.searchFor(product);
        assertEquals(
                sw.ell(String.format(PRODUCT_ASSERT, "")).size(),
                sw.ell(String.format(PRODUCT_ASSERT, product)).size(),
                "Not every product on list is " + product
        );
    }
}
