package cshr.careersite.steps.backend;

import cshr.careersite.utils.RandomTestData;
import cshr.careersite.pages.backend.teams.TeamPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TeamPageSteps {

    TeamPage teamPage;

    @Step
    public void openTeamListPage()
    {
        teamPage.openTeamsPage();
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

        teamPage.typeInto(teamPage.tagDisplayName, "tempTeamName");
        teamPage.typeInto(teamPage.tagDisplayName2, "I am pretty line 2");
        teamPage.typeInto(teamPage.tagDisplayName3, "I am pretty line 3");
        teamPage.typeInto(teamPage.tagThemeColor, "#000000");
        teamPage.selectLogo();        teamPage.addNewTeamButton.click();

        if (teamPage.isTeamCreated(tempTeamName))
        {
            Serenity.setSessionVariable("Team Name").to(tempTeamName);
        }
    }

    @Step
    public void deleteAllTestTeams()
    {
        teamPage.searchTeams("test_");
        teamPage.waitFor(500);

        List<WebElementFacade> teamNames = teamPage.teamNames;

        String[] teams = new String[teamNames.size()];
        for(int i=0; i < teamNames.size(); i++)
        {
            teams[i] = teamNames.get(i).getText();
        }

        for(String team: teams) {
            teamPage.deleteTeamByName(team);
        }

    }
}
