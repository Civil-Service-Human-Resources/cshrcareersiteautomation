package cshr.careersite.steps;

import cshr.careersite.pages.NewUserPage;
import cucumber.api.java.en.And;

public class NewUserPageStepDefs {

    NewUserPage newUserPage;

    @And("^I am on the create new user page$")
    public void iAmOnTheCreateNewUserPage() throws Throwable {
        newUserPage.open();
    }
}
