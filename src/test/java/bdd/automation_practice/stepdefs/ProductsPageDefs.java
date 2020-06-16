package bdd.automation_practice.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lib.test_setup.TestBase;
import pop.automation_practice.products.AddedItemSummary;
import pop.automation_practice.products.CartList;
import pop.automation_practice.products.ItemTile;
import pop.automation_practice.test_data.Product;
import pop.automation_practice.test_data.UserProducts;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ProductsPageDefs extends TestBase {

    UserProducts userProducts;
    Double sum = 0.0;

    @Before
    public void setData() {
        userProducts = new UserProducts();
    }

    @Given("user wants following products")
    public void user_wants_following_products(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists();

        for (List<String> cols : rows) {
            userProducts.addProduct(new Product(cols.get(0), Double.valueOf(cols.get(1))));
        }
    }

    @When("user adding products")
    public void user_adding_products() {
        ItemTile itemTile = new ItemTile();
        AddedItemSummary addedItemSummary = new AddedItemSummary();
        for (Product userProduct : userProducts.getProducts()) {
            sum += itemTile.getPrice(userProduct.getName());
            itemTile.hoverProduct(userProduct.getName()).addToCart(userProduct.getName());
            addedItemSummary.continueShopping();
        }
    }

    @Then("cart shows total cost")
    public void cart_shows_total_cost() {
        CartList cartList = new CartList();
        cartList.expandCart();
        Double shippingCost = cartList.getShippingCost();
        assertEquals(
                sum + shippingCost,
                userProducts.getTotalPrice() + shippingCost,
                "Evaluated cost is not correct"
        );
    }
}
