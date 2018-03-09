package cshr.careersite.stepDefs;

import cshr.careersite.pages.users.AllUsersPage;
import cshr.careersite.pages.users.EditUsersPage;
import cshr.careersite.steps.LoginSteps;
import cshr.careersite.steps.UserSteps;
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
    UserSteps userSteps;

    AllUsersPage allUsersPage;
    EditUsersPage editUsersPage;

    @And("^I am on the create new user page$")
    public void iAmOnTheCreateNewUserPage() throws Throwable {
        userSteps.openNewUserPage();
    }

    @When("^I create a new user with a default role and a team$")
    public void iCreateANewUserWithADefaultRoleAndATeam() throws Throwable {
        Assert.assertTrue("User Creation Failed", userSteps.createNewUser());
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
        userSteps.openNewUserPage();
        Assert.assertTrue("User Creation Failed", userSteps.createNewUser());
    }

    @And("^I login as the newly created user$")
    public void iLoginAsTheNewlyCreatedUser() throws Throwable {
        String currentUserName = Serenity.sessionVariableCalled("User Name");
        loginSteps.logoutAndLoginWithDifferentCredentials(currentUserName, "password123");
        Assert.assertTrue(loginSteps.isLoggedinUserNameCorrect(currentUserName));
    }

    @And("^I navigate to edit user page$")
    public void iNavigateToEditUserPage() throws Throwable {
        userSteps.openAllUsersPage();
    }

    @When("^I reassign role for the user$")
    public void iReassignRoleForTheUser() throws Throwable {
        String currentUserName = Serenity.sessionVariableCalled("User Name");
        //**** To replace with new username when user functionality is working
        allUsersPage.clickUserNameLink("ContentAuthor1");
        editUsersPage.nickName.sendKeys("contentauthor1");
        editUsersPage.adminUserRoleCheckbox.click();
        editUsersPage.updateUser.click();
    }

    @Then("^the user role should be updated$")
    public void theUserRoleShouldBeUpdated() throws Throwable {
        userSteps.openAllUsersPage();
        String currentUserName = Serenity.sessionVariableCalled("User Name");

        //**** Need to replace username below
        Assert.assertTrue(allUsersPage.getRolesForParticularUserName("ContentAuthor1").contains("Administrator"));
    }
}
