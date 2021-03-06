package cshr.careersite.stepDefs.backend;

import cshr.careersite.steps.backend.RoleSteps;
import cshr.careersite.steps.backend.TeamPageSteps;
import cshr.careersite.steps.backend.UserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class CleanupStepDefs {
    @Steps
    UserSteps userSteps;

    @Steps
    RoleSteps roleSteps;

    @Steps
    TeamPageSteps teamPageSteps;

    @When("^I delete all test users$")
    public void iDeleteAllTestUsers() throws Throwable {
        userSteps.openAllUsersPage();
        userSteps.deleteAllTestUsers();

    }

    @Then("^the all test users are deleted$")
    public void theAllTestUsersAreDeleted() throws Throwable {
    }

    @When("^I delete all test roles$")
    public void iDeleteAllTestRoles() throws Throwable {

    }

    @Then("^the all test roles are deleted$")
    public void theAllTestRolesAreDeleted() throws Throwable {
        roleSteps.openAllRolesPage();
        roleSteps.deleteAllTestRoles();
    }

    @When("^I delete all test teams$")
    public void iDeleteAllTestTeams() throws Throwable {
        teamPageSteps.openTeamListPage();
        teamPageSteps.deleteAllTestTeams();
    }

    @Then("^the all test teams are deleted$")
    public void theAllTestTeamsAreDeleted() throws Throwable {

    }
}
