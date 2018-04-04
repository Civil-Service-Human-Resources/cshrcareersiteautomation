package cshr.careersite.stepDefs.backend;

import cshr.careersite.steps.backend.LoginSteps;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;

public class GenericStepDefs {
    @Steps
    LoginSteps loginSteps;

    @Given("^I am logged in as a (techadmin|contentadmin|contentauthor|contentapprover|contentpublisher|contentsnippets)")
    public void iAmLoggedInAsATechadmin(String admin) throws Throwable {
       loginSteps.logoutAndLoginWithDifferentCredentials(admin);

    }
}
