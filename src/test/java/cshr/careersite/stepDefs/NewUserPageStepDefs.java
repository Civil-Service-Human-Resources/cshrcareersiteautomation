package cshr.careersite.stepDefs;

import cshr.careersite.steps.LoginSteps;
import cshr.careersite.steps.NewUserPageSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class NewUserPageStepDefs {

    @Steps
    LoginSteps loginSteps;

    @Steps
    NewUserPageSteps newUserPageSteps;

    @And("^I am on the create new user page$")
    public void iAmOnTheCreateNewUserPage() throws Throwable {
        newUserPageSteps.openNewUserPage();
    }

    @When("^I create a new user with a default role and a team$")
    public void iCreateANewUserWithADefaultRoleAndATeam() throws Throwable {
        /*String username = newUserPage.createNewUser();

        Serenity.setSessionVariable("User Name").to(username);
        Assert.assertNotEquals("USER_CREATION_FAILED", username);*/
        Assert.assertTrue("User Creation Failed", newUserPageSteps.createNewUser());
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

    @And("^I create a new user$")
    public void iCreateANewUser() throws Throwable {
        newUserPageSteps.openNewUserPage();
        newUserPageSteps.createNewUser();
        Assert.assertTrue("User Creation Failed", newUserPageSteps.createNewUser());

    }

    @And("^I login as the newly created user$")
    public void iLoginAsTheNewlyCreatedUser() throws Throwable {
        String currentUserName = Serenity.sessionVariableCalled("User Name");
        loginSteps.logoutAndLoginWithDifferentCredentials(currentUserName, "password123");
        Assert.assertTrue(loginSteps.isLoggedinUserNameCorrect(currentUserName));
    }

    @And("^I navigate to edit user page$")
    public void iNavigateToEditUserPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I reassign role for the user$")
    public void iReassignRoleForTheUser() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the user role should be updated$")
    public void theUserRoleShouldBeUpdated() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
