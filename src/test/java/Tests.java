import org.testng.Assert;
import org.testng.annotations.Test;
import pop.automation_practice.AddedItemSummary;
import pop.automation_practice.CartList;
import pop.automation_practice.ItemTile;
import pop.automation_practice.navigation.MainNavBar;
import pop.automation_practice.navigation.MainNavItems;
import test_setup.TestSetup;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Test class with all testcases for http://automationpractice.com/ site.
 *
 * @author Adrian Jankowski
 */

public class Tests extends TestSetup {

    private final static String PAGE_URL = "http://automationpractice.com/index.php";

    @Test(priority = 1)
    public void smokeTest() {
        openPage(PAGE_URL);
        Assert.assertEquals("My Store", getTitle());
    }

    @Test(priority = 2)
    public void iterateThroughMenuItems() {
        String ASSERT_FORMAT = "//div[contains(@class, 'cat_desc') and contains(., '%s')]";
        MainNavBar mainNavBar = new MainNavBar();

        openPage(PAGE_URL);
        for (MainNavItems mainNavItem : MainNavItems.values()) {
            mainNavBar.chooseMenuItem(mainNavItem);
            taxAction.assertXpath(String.format(ASSERT_FORMAT, mainNavItem.getLabel()));
        }
    }

    @Test(priority = 3)
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

        openPage(PAGE_URL);
        new MainNavBar().chooseMenuItem(MainNavItems.WOMEN);
        for(String productName : products) {
            sum += itemTile.getPrice(productName);
            itemTile.hoverProduct(productName).addToCart(productName);
            addedItemSummary.continueShopping();
        }
        totalCost = cartList.expandCart().getTotalCost();
        shippingCost = cartList.getShippingCost();

        Assert.assertEquals(
                sum + shippingCost, totalCost,
                "Evaluated cost is not correct"
        );
    }
}
