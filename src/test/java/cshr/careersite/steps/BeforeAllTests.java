package cshr.careersite.steps;

import cshr.careersite.model.UserType;
import cshr.careersite.pages.backend.teams.TeamPage;
import cshr.careersite.steps.backend.LoginSteps;
import cshr.careersite.steps.backend.MediaSteps;
import cshr.careersite.steps.backend.TeamPageSteps;
import cshr.careersite.steps.backend.UserSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BeforeAllTests {

    @Steps
    private UserSteps userSteps;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private TeamPageSteps teamPageSteps;

    @Steps
    private MediaSteps mediaSteps;

    private TeamPage teamPage;


    public void BeforeAll() {

      /* File lockFile = new File("./lock");
       File file = new File("./BeforeAll.txt");

       try {
           if(lockFile.createNewFile()) {
               if (file.createNewFile()) {
                   System.out.println("File is created!");*/
        createTeam1And2();
        assignTeamsToDefaultRoles();
        uploadRelevantImages();
              /* } else {
                   System.out.println("File already exists.");
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
       }*/
    }

    private void createTeam1And2()
    {
        loginSteps.logoutAndLoginWithDifferentCredentials(UserType.TECH_ADMIN.getValue());
        teamPageSteps.openTeamListPage();
        if (!teamPage.checkIfTeamNameExists("Team1")) {
            teamPage.typeInto(teamPage.teamName, "Team1");
            teamPage.typeInto(teamPage.tagDisplayName, "Team1");
            teamPage.typeInto(teamPage.tagDisplayName2, "I am pretty line 2");
            teamPage.typeInto(teamPage.tagDisplayName3, "I am pretty line 3");
            teamPage.typeInto(teamPage.tagThemeColor, "#000000");
            teamPage.selectLogo();
            teamPage.addNewTeamButton.click();
            WebDriverWait wait = new WebDriverWait(teamPage.getDriver(), 10);
            wait.until(ExpectedConditions.attributeToBe(teamPage.teamName, "value", ""));
            Assert.assertTrue(teamPage.checkIfTeamNameExists("Team1"));
        }

        if (!teamPage.checkIfTeamNameExists("Team2")) {
            teamPage.teamName.waitUntilEnabled();
            teamPage.typeInto(teamPage.teamName, "Team2");
            teamPage.typeInto(teamPage.tagDisplayName, "Team2");
            teamPage.typeInto(teamPage.tagThemeColor, "#008000");
            teamPage.typeInto(teamPage.tagDisplayName2, "I am pretty line 2");
            teamPage.typeInto(teamPage.tagDisplayName3, "I am pretty line 3");
            teamPage.selectLogo();
            teamPage.addNewTeamButton.click();
            WebDriverWait wait = new WebDriverWait(teamPage.getDriver(), 10);
            wait.until(ExpectedConditions.attributeToBe(teamPage.teamName, "value", ""));
            Assert.assertTrue(teamPage.checkIfTeamNameExists("Team2"));
        }
    }

    private void assignTeamsToDefaultRoles()
    {
        userSteps.openAllUsersPage();
        userSteps.updateUser("ContentAdmin1", "team1");
        userSteps.openAllUsersPage();
        userSteps.updateUser("ContentApprover1", "team1");
        userSteps.openAllUsersPage();
        userSteps.updateUser("ContentAuthor1", "team1");
        userSteps.openAllUsersPage();
        userSteps.updateUser("ContentPublisher1", "team1And2");
        userSteps.openAllUsersPage();
        userSteps.updateUser("ContentSnippets1", "team1");
        userSteps.openAllUsersPage();
        userSteps.updateUser("techadmin", "team1And2");
    }

    private void uploadRelevantImages()
    {
        System.out.println("before @media");
        mediaSteps.addMediaRequiredForTests();
    }
}
