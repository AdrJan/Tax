package automation_practice.steps;

import io.cucumber.java.en.Given;
import pop.automation_practice.CommonPage;

public class CommonSteps {

    private static final CommonPage commonPage = new CommonPage();

    @Given("Go to page {word}")
    public void openPage(String url) {
        commonPage.openPage(url);
    }
}
