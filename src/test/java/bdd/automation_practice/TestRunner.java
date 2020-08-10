package bdd.automation_practice;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * @author Adrian Jankowski
 * <p>
 * Cucumber test runner class.
 */

@CucumberOptions(features = "src/test/resources")
public class TestRunner extends AbstractTestNGCucumberTests {

}
