package cshr.careersite.stepDefs.backend;

import cshr.careersite.model.PublishActionType;
import cshr.careersite.model.UserType;
import cshr.careersite.model.Workflows;
import cshr.careersite.pages.backend.page.AllPages;
import cshr.careersite.pages.backend.teams.EditTeamPage;
import cshr.careersite.pages.backend.teams.TeamPage;
import cshr.careersite.steps.backend.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class TeamPageStepDefs {

    private TeamPage teamPage;

    private EditTeamPage editTeamPage;

    @Steps
    private TeamPageSteps teamPageSteps;

    @Steps
    private PageSteps pageSteps;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private WorkflowSteps workflowSteps;

    @Steps
    private UserSteps userSteps;

    @Steps
    private AllPages allPages;

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
        Assert.assertTrue("Page not created or page status is not pending", pageSteps.addRandomPage(new String[]{arg0}, PublishActionType.PUBLISH));
    }

    @And("^I publish the page$")
    public void iPublishThePage() throws Throwable {
        loginSteps.logoutAndLoginWithDifferentCredentials(UserType.CONTENT_APPROVER.getValue());
        workflowSteps.acceptRejectWorkflow(Workflows.ACCEPT, UserType.CONTENT_APPROVER);
        loginSteps.logoutAndLoginWithDifferentCredentials(UserType.CONTENT_PUBLISHER.getValue());
        workflowSteps.acceptRejectWorkflow(Workflows.COMPLETE, UserType.CONTENT_PUBLISHER);
    }

    @When("^I create a new user assigned to (.*)$")
    public void iCreateANewUserAssignedToTeam(String arg0) throws Throwable {
        loginSteps.logoutAndLoginWithDifferentCredentials(UserType.CONTENT_ADMIN.getValue());
        userSteps.openNewUserPage();

        boolean team1 = true;
        boolean team2 = false;

        if(arg0.equals("team2"))
        {
            team1 = false;
            team2 = true;
        }

        Assert.assertTrue("User Creation Failed", userSteps.createNewUser(team1, team2));

    }

    @Then("^I should be able to see the published page$")
    public void iShouldBeAbleToSeeThePublishedPage() throws Throwable {
        String pageName = Serenity.sessionVariableCalled("Page Name");

        allPages.openPagesMenu();
        Assert.assertTrue(allPages.isPagePublished(pageName));
    }

    @Then("^I should not be able to see the published page$")
    public void iShouldNotBeAbleToSeeThePublishedPage() throws Throwable {
        String pageName = Serenity.sessionVariableCalled("Page Name");

        allPages.openPagesMenu();
        Assert.assertFalse(allPages.isPagePublished(pageName));

    }

    @And("^I add a new page with the default template and assign to (.*) and (.*)$")
    public void iAddANewPageWithTheDefaultTemplateAndAssignedToTeamAndTeam(String arg0, String arg1) throws Throwable {
        Assert.assertTrue("Page not created or page status is not pending", pageSteps.addRandomPage(new String[]{arg0, arg1},
                PublishActionType.PUBLISH));

    }
}
