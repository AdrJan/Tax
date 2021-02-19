package automation_practice.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pop.automation_practice.MainPage;
import pop.automation_practice.dictionary.AutomationPracticePageNames;

public class MainPageSteps {

    private final String STEP_AFFIX = AutomationPracticePageNames.MAIN_PAGE_NAME;
    private final MainPage mainPage = new MainPage();

    @When(STEP_AFFIX + "search for {word}")
    public void searchFor(String text) {
        mainPage.searchFor(text);
    }

    @Then(STEP_AFFIX + "main page is displayed")
    public void mainPageIsDisplayed() {
        mainPage.verifyIfIsDisplayed();
    }
}
