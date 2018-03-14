package cshr.careersite.steps;

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
        String teamName = teamPage.addTeam(addParentTeam);
        Serenity.setSessionVariable("Team Name").to(teamName);
    }
}
