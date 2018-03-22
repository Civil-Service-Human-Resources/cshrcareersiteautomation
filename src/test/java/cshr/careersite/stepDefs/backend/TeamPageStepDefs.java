package cshr.careersite.stepDefs.backend;

import cshr.careersite.pages.backend.teams.EditTeamPage;
import cshr.careersite.pages.backend.teams.TeamPage;
import cshr.careersite.steps.backend.TeamPageSteps;
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
        editTeamPage.updateTeamButton.click();
    }

    @Then("^the team is updated$")
    public void theTeamIsUpdated() throws Throwable {
        String teamName = Serenity.sessionVariableCalled("Team Name");
        teamPageSteps.openTeamListPage();
        teamPage.selectTeamByName(teamName);
        Assert.assertEquals("Team1" ,editTeamPage.parentTeam.getSelectedVisibleTextValue());
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

    @When("^I try to add a team with the same name as an already existing team$")
    public void iTryToAddATeamWithTheSameNameAsAnAlreadyExistingTeam() throws Throwable {
        teamPage.typeInto(teamPage.teamName, "Team1");
        teamPage.addNewTeamButton.click();
    }

    @Then("^an error message indicating team already exists should be shown$")
    public void anErrorMessageIndicatingTeamAlreadyExistsShouldBeShown() throws Throwable {
        teamPage.waitFor(teamPage.error);
        Assert.assertTrue(teamPage.error.isCurrentlyVisible());
    }

    @And("^I add a new page with the default template and assigned to (.*)$")
    public void iAddANewPageWithTheDefaultTemplateAndAssignedToTeam(String arg0) throws Throwable {

    }

    @And("^I publish the page$")
    public void iPublishThePage() throws Throwable {

    }

    @When("^I create a new user assigned to (.*)$")
    public void iCreateANewUserAssignedToTeam(String arg0) throws Throwable {

    }

    @Then("^I should be able to see the published page$")
    public void iShouldBeAbleToSeeThePublishedPage() throws Throwable {

    }

    @Then("^I should not be able to see the published page$")
    public void iShouldNotBeAbleToSeeThePublishedPage() throws Throwable {

    }

    @And("^I add a new page with the default template and assigned to (.*) and (.*)$")
    public void iAddANewPageWithTheDefaultTemplateAndAssignedToTeamAndTeam(int arg0, int arg1) throws Throwable {

    }
}
