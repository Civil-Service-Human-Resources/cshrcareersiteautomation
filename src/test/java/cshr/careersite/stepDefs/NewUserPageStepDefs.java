package cshr.careersite.stepDefs;

import cshr.careersite.pages.CareerSiteHomePage;
import cshr.careersite.pages.NewUserPage;
import cshr.careersite.steps.LoginSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class NewUserPageStepDefs {

    NewUserPage newUserPage;
    CareerSiteHomePage careerSiteHomePage;

    @Steps
    LoginSteps loginSteps;

    @And("^I am on the create new user page$")
    public void iAmOnTheCreateNewUserPage() throws Throwable {
        newUserPage.open("new.user", PageObject.withParameters());
    }

    @When("^I create a new user with a default role and a team$")
    public void iCreateANewUserWithADefaultRoleAndATeam() throws Throwable {
        String username = newUserPage.createNewUser();

        Serenity.setSessionVariable("User Name").to(username);
        Assert.assertNotEquals("USER_CREATION_FAILED", username);
    }

    @Then("^a user is created$")
    public void aUserIsCreated() throws Throwable {
        String currentUserName = Serenity.sessionVariableCalled("User Name");
        Assert.assertNotNull(currentUserName);
    }

    @And("^I should be able to login with the newly created user$")
    public void iShouldBeAbleToLoginWithTheNewlyCreatedUser() throws Throwable {
        String currentUserName = Serenity.sessionVariableCalled("User Name");
        loginSteps.logoutAndLoginWithDifferentCredentials(currentUserName, "password123");
        Assert.assertTrue(loginSteps.isLoggedinUserNameCorrect(currentUserName));
    }
}
