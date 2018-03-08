package cshr.careersite.stepDefs;

import cshr.careersite.steps.LoginSteps;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class GenericStepDefs {
    @Steps
    LoginSteps loginSteps;

    @Given("^I am logged in as a (techadmin|contentadmin|contentauthor|contentapprover|contentpublisher)")
    public void iAmLoggedInAsATechadmin(String admin) throws Throwable {
       loginSteps.logoutAndLoginWithDifferentCredentials(admin);

    }
}
