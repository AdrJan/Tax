package automation_practice;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/automation_practice/resources/example.feature",
        glue = {
                "core.lib.test_setup",
                "automation_practice.steps"
        }
)
public class TestRunner {
}
