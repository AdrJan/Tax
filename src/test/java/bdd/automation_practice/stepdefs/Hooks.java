package bdd.automation_practice.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lib.test_setup.TestSetup;

public class Hooks extends TestSetup {

    @Before
    public void init() {
        setUp();
        clearCookie();
    }

    @After
    public void tearDown() {
        super.tearDown();
    }
}
