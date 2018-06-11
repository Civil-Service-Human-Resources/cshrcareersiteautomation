package cshr.careersite.stepDefs;

import cshr.careersite.steps.BeforeAllTests;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class BeforeAllStepDefs {

    @Steps
    BeforeAllTests beforeAllTests;

    @Given("^I run the before all hook$")
    public void iRunTheBeforeAllHook() throws Throwable {
        beforeAllTests.BeforeAll();
    }

}
