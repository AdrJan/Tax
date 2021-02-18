package core.lib.page.steps;

import core.lib.page.pop.CommonPage;
import io.cucumber.java.en.Given;

public class CommonSteps {

    private static final CommonPage commonPage = new CommonPage();

    @Given("Go to page {word}")
    public void openPage(String url) {
        commonPage.openPage(url);
    }
}
