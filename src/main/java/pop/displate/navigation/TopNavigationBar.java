package pop.displate.navigation;

import lib.test_setup.TestBase;

public class TopNavigationBar extends TestBase {

    public void searchProductsByKeyword(String keyword) {
        taxAction.submitTextElx(elX("//input[contains(@class, 'search__input')]"), keyword);
    }
}
