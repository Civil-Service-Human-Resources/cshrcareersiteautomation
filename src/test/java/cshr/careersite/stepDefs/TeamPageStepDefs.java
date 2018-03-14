package cshr.careersite.stepDefs;

import cshr.careersite.pages.teams.EditTeamPage;
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
    EditTeamPage editTeamPage;

    @Steps
    TeamPageSteps teamPageSteps;

    @And("^I navigate to the create new team page$")
    public void iNavigateToTheCreateNewTeamPage() throws Throwable {
        teamPageSteps.openTeamListPage();
    }

    @When("^I add a new team$")
    public void iAddANewTeam() throws Throwable {
        teamPageSteps.addNewTeam(true);
    }

    @Then("^the team is added$")
    public void theTeamIsAdded() throws Throwable {
        String teamName = Serenity.sessionVariableCalled("Team Name");
        Assert.assertTrue(teamPage.checkIfTeamNameExists(teamName));
    }

    @And("^I create a new team$")
    public void iCreateANewTeam() throws Throwable {
        teamPageSteps.openTeamListPage();
        teamPageSteps.addNewTeam(false);
    }

    @When("^I edit the team$")
    public void iEditTheTeam() throws Throwable {
        String teamName = Serenity.sessionVariableCalled("Team Name");
        teamPage.selectTeamByName(teamName);
        editTeamPage.selectFromDropdown(editTeamPage.parentTeam, "Team1");
        editTeamPage.addNewTeamButton.click();
    }

    @Then("^the team is updated$")
    public void theTeamIsUpdated() throws Throwable {
        String teamName = Serenity.sessionVariableCalled("Team Name");
        teamPage.selectTeamByName(teamName);
        Assert.assertEquals("Team1" ,editTeamPage.parentTeam.getText());
    }

    @When("^I choose to delete the just created team$")
    public void iChooseToDeleteTheJustCreatedTeam() throws Throwable {
        String teamName = Serenity.sessionVariableCalled("Team Name");
        teamPage.deleteTeamByName(teamName);
    }

    @Then("^the team is deleted$")
    public void theTeamIsDeleted() throws Throwable {
        String teamName = Serenity.sessionVariableCalled("Team Name");
        Assert.assertFalse(teamPage.checkIfTeamNameExists(teamName));
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
