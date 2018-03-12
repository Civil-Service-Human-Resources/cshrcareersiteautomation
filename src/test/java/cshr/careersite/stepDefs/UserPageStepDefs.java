package cshr.careersite.stepDefs;

import cshr.careersite.pages.users.AllUsersPage;
import cshr.careersite.pages.users.DeleteUsersPage;
import cshr.careersite.pages.users.EditUsersPage;
import cshr.careersite.steps.LoginSteps;
import cshr.careersite.steps.UserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class UserPageStepDefs {

    @Steps
    LoginSteps loginSteps;

    @Steps

    UserSteps userSteps;
    AllUsersPage allUsersPage;
    EditUsersPage editUsersPage;
    DeleteUsersPage deleteUsersPage;

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

        allUsersPage.clickUserNameLink(currentUserName);
        editUsersPage.typeInto(editUsersPage.nickName, currentUserName);
        editUsersPage.adminUserRoleCheckbox.click();
        editUsersPage.updateUser.click();
    }

    @Then("^the user role should be updated$")
    public void theUserRoleShouldBeUpdated() throws Throwable {
        String currentUserName = Serenity.sessionVariableCalled("User Name");

        userSteps.openAllUsersPage();

        Assert.assertTrue(allUsersPage.getRolesForParticularUserName(currentUserName).contains("Administrator"));
    }

    @When("^I assign a new group for the user$")
    public void iAssignANewGroupForTheUser() throws Throwable {
        String currentUserName = Serenity.sessionVariableCalled("User Name");

        allUsersPage.clickUserNameLink(currentUserName);
        editUsersPage.typeInto(editUsersPage.nickName, currentUserName);
        editUsersPage.defaultTeam2.click();
        editUsersPage.updateUser.click();
    }

    @Then("^the user groups should be updated$")
    public void theUserGroupsShouldBeUpdated() throws Throwable {
        userSteps.openAllUsersPage();
        String currentUserName = Serenity.sessionVariableCalled("User Name");

        Assert.assertTrue(allUsersPage.getGroupsForParticularUserName(currentUserName).contains("Team2"));
    }

    @And("^I navigate to the all users page$")
    public void iNavigateToTheAllUsersPage() throws Throwable {
        userSteps.openAllUsersPage();
    }

    @When("^I choose to delete the just created user$")
    public void iChooseToDeleteTheJustCreatedUser() throws Throwable {
        String currentUserName = Serenity.sessionVariableCalled("User Name");

        allUsersPage.deleteUser(currentUserName);
        deleteUsersPage.confirmDelete.click();
    }

    @Then("^the user is deleted$")
    public void theUserIsDeleted() throws Throwable {
        String currentUserName = Serenity.sessionVariableCalled("User Name");

        Assert.assertFalse(allUsersPage.checkIfUserNameExists(currentUserName));
    }
}