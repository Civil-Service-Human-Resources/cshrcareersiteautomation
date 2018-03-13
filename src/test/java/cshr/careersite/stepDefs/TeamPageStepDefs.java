package cshr.careersite.stepDefs;

import cshr.careersite.pages.teams.TeamPage;
import cshr.careersite.steps.TeamPageSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class TeamPageStepDefs {

    TeamPage teamPage;

    @Steps
    TeamPageSteps teamPageSteps;

    @And("^I navigate to the create new team page$")
    public void iNavigateToTheCreateNewTeamPage() throws Throwable {
        teamPageSteps.openTeamListPage();
    }

    @When("^I add a new team$")
    public void iAddANewTeam() throws Throwable {
        String teamName = teamPage.addTeam(true);
        Serenity.setSessionVariable("Team Name").to(teamName);
    }

    @Then("^the team is added$")
    public void theTeamIsAdded() throws Throwable {
        String teamName = Serenity.sessionVariableCalled("Team Name");
        Assert.assertTrue(teamPage.checkIfTeamNameExists(teamName));

    }

    @And("^I create a new team$")
    public void iCreateANewTeam() throws Throwable {

    }

    @When("^I edit the team$")
    public void iEditTheTeam() throws Throwable {

    }

    @Then("^the team is updated$")
    public void theTeamIsUpdated() throws Throwable {

    }

    @When("^I choose to delete the just created team$")
    public void iChooseToDeleteTheJustCreatedTeam() throws Throwable {

    }

    @Then("^the team is deleted$")
    public void theTeamIsDeleted() throws Throwable {

    }

    @And("^I am on create new team page$")
    public void iAmOnCreateNewTeamPage() throws Throwable {

    }

    @When("^I try to add a team with the same name as an already existing team$")
    public void iTryToAddATeamWithTheSameNameAsAnAlreadyExistingTeam() throws Throwable {

    }

    @Then("^an error message indicating team already exists should be shown$")
    public void anErrorMessageIndicatingTeamAlreadyExistsShouldBeShown() throws Throwable {

    }

}
