package pop.automation_practice;

import core.lib.testbase.TestBase;
import io.qameta.allure.Step;

public class CommonPage extends TestBase {

    @Step("Opening a page by url: {0}")
    public void openPage(String url) {
        sw.openPage(url);
    }
}
