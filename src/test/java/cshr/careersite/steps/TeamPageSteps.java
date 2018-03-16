package cshr.careersite.steps;

import cshr.careersite.Utils.RandomTestData;
import cshr.careersite.pages.teams.TeamPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

public class TeamPageSteps {

    TeamPage teamPage;

    @Step
    public void openTeamListPage()
    {
        teamPage.open("new.team", PageObject.withParameters());
    }

    @Step
    public void addNewTeam(boolean addParentTeam)
    {
        RandomTestData randomTestData = new RandomTestData();
        String tempTeamName = "test_team_" + randomTestData.getRandomString(5);

        teamPage.typeInto(teamPage.teamName, tempTeamName);

        if (addParentTeam) {
            teamPage.selectFromDropdown(teamPage.parentTeam, "Team1");
        }

        teamPage.typeInto(teamPage.teamDescription, tempTeamName);
        teamPage.addNewTeamButton.click();

        if (teamPage.isTeamCreated(tempTeamName))
        {
            Serenity.setSessionVariable("Team Name").to(tempTeamName);
        }
    }
}
