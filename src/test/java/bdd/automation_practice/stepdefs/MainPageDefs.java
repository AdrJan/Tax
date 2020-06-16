package bdd.automation_practice.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lib.test_setup.TestBase;
import pop.automation_practice.navigation.MainNavBar;

/**
 * @author Adrian Jankowski
 * <p>
 * Class defining steps for main page of www.automationpractice.com.
 */

public class MainPageDefs extends TestBase {

    private final static String PAGE_URL = "http://automationpractice.com/index.php";

    private final static String ASSERT_CATEGORY = "//div[contains(@class, 'cat_desc') and contains(., '%s')]";

    @Given("user is on Home Page")
    public void user_is_on_Home_Page() {
        openPage(PAGE_URL);
    }

    @When("user clicks on {string} category")
    public void user_clicks_on_category(String menuLabel) {
        new MainNavBar().chooseMenuItem(menuLabel);
    }

    @Then("{string} page is displayed")
    public void page_is_displayed(String menuLabel) {
        taxAction.assertXpath(
                String.format(ASSERT_CATEGORY, menuLabel),
                "Wrong item!"
        );
    }
}
