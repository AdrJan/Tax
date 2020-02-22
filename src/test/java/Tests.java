import actions.TaxAction;
import org.testng.Assert;
import org.testng.annotations.Test;
import pop.automation_practice.navigation.MainNavBar;
import pop.automation_practice.navigation.MainNavItems;
import test_setup.TestSetup;

/**
 * Test class with all testcases for http://automationpractice.com/ site.
 *
 * @author Adrian Jankowski
 */

public class Tests extends TestSetup {

    @Test
    public void smokeTest() {
        openPage("https://www.google.com");
        Assert.assertEquals("Google", getTitle());
    }

    @Test
    public void iterateThroughMenuItems() {
        String ASSERT_FORMAT = "//div[contains(@class, 'cat_desc') and contains(., '%s')]";
        MainNavBar mainNavBar = new MainNavBar();

        openPage("http://automationpractice.com/index.php");
        for (MainNavItems mainNavItem : MainNavItems.values()) {
            mainNavBar.chooseMenuItem(mainNavItem);
            taxAction.assertXpath(String.format(ASSERT_FORMAT, mainNavItem.getLabel()));
        }
    }
}
