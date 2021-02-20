package automation_practice.steps.components;

import io.cucumber.java.en.When;
import pop.automation_practice.dictionary.AutomationPracticePageNames;
import pop.automation_practice.navigation.MainNavBar;

public class MainNavBarSteps {

    private final String STEP_AFFIX = AutomationPracticePageNames.MAIN_NAV_BAR_COMPONENT;
    private final MainNavBar mainNavBar = new MainNavBar();

    @When(STEP_AFFIX + "User select option {} from menu")
    public void selectMainNavBarOption(String option) {
        mainNavBar.chooseMenuItem(option);
    }
}
